# Face Mask Detection Project

This project implements a face mask detection system using OpenCV and a pre-trained deep learning model. The system captures video from the webcam, processes each frame to detect faces, and indicates whether a mask is detected.

## Project Structure

```
FaceMaskDetection
├── src
│   ├── FaceMaskDetection.java
├── lib
│   └── opencv.jar
├── models
│   ├── face_mask_detection_model.caffemodel
│   └── face_mask_detection_config.prototxt
├── README.md
└── .gitignore
```

## Setup Instructions

1. **Install OpenCV**: Download and install OpenCV for Java. Ensure that the `opencv.jar` file is included in the `lib` directory.

2. **Add OpenCV to Classpath**: Make sure to add `lib/opencv.jar` to your project's classpath.

3. **Download Model Files**: Place the pre-trained model files (`face_mask_detection_model.caffemodel` and `face_mask_detection_config.prototxt`) in the `models` directory.

4. **Compile the Project**: Compile the Java files in the `src` directory.

5. **Run the Application**: Execute the `FaceMaskDetection` class to start the webcam and begin detecting face masks.

## Usage

- The application will open the webcam and start processing video frames.
- Detected faces will be highlighted with bounding boxes.
- Labels will indicate whether a mask is detected.

## .gitignore

This project includes a `.gitignore` file to exclude unnecessary files from version control. Make sure to add any additional files or directories that should be ignored.

## License

This project is licensed under the MIT License.