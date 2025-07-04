// filepath: /FaceMaskDetection/FaceMaskDetection/src/FaceMaskDetection.java
import java.io.IOException;
import org.opencv.core.*;
import org.opencv.dnn.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class FaceMaskDetection {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String modelPath = "models/face_mask_detection_model.caffemodel";
        String configPath = "models/face_mask_detection_config.prototxt";
        Net net = Dnn.readNetFromCaffe(configPath, modelPath);

        VideoCapture camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Could not open camera.");
            return;
        }

        Mat frame = new Mat();
        while (camera.read(frame)) {
            Mat blob = Dnn.blobFromImage(frame, 1.0, new Size(300, 300), new Scalar(104, 117, 123), false, false);
            net.setInput(blob);
            Mat detections = net.forward();

            for (int i = 0; i < detections.size(2); i++) {
                double confidence = detections.get(0, 0, i, 2)[0];
                if (confidence > 0.5) {
                    int x1 = (int) (detections.get(0, 0, i, 3)[0] * frame.cols());
                    int y1 = (int) (detections.get(0, 0, i, 4)[0] * frame.rows());
                    int x2 = (int) (detections.get(0, 0, i, 5)[0] * frame.cols());
                    int y2 = (int) (detections.get(0, 0, i, 6)[0] * frame.rows());

                    Imgproc.rectangle(frame, new Point(x1, y1), new Point(x2, y2), new Scalar(0, 255, 0), 2);
                    String label = "Mask Detected";
                    Imgproc.putText(frame, label, new Point(x1, y1 - 10), Imgproc.FONT_HERSHEY_SIMPLEX, 0.5, new Scalar(0, 255, 0), 2);
                }
            }

            Imgcodecs.imwrite("output.jpg", frame);
        }

        camera.release();
    }
}