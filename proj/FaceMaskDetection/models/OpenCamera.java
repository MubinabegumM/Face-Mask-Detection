package FaceMaskDetection.models;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

public class OpenCamera {
    static {
        // Load OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        VideoCapture camera = new VideoCapture(0); // 0 is the default camera

        if (!camera.isOpened()) {
            System.out.println("Error: Camera not found!");
            return;
        }

        Mat frame = new Mat();

        while (true) {
            if (camera.read(frame)) {
                HighGui.imshow("Webcam View", frame);

                if (HighGui.waitKey(30) >= 0) {
                    break; // Exit when any key is pressed
                }
            }
        }

        camera.release();
        HighGui.destroyAllWindows();
    }
}
