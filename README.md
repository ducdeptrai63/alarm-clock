# Alarm Clock (Java Console Application)

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![JDK](https://img.shields.io/badge/JDK-8%2B-blue?style=for-the-badge)
![OS](https://img.shields.io/badge/Platform-Linux%20%7C%20Windows-lightgrey?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

## Overview 
A simple alarm clock application written in Java.
The program allows users to input a specific time and will trigger an alarm when the system time matches the scheduled time.

## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
- [Folder Description](#folder-description)
- [Requirements](#requirements)
- [How to Compile and Run](#how-to-compile-and-run)
- [Audio Format](#audio-format)
- [Notes](#notes)
- [Technologies Used](#technologies-used)
- [Future Improvements](#future-improvements)
- [Learning Outcome](#learning-outcome)
- [License](#license)

## Project Structure
```text
alarm-clock/
├── README.md
├── .gitignore
├── src/
│   ├── AlarmClock.java
│   └── Main.java
└── resources/
    └── 3dabrar-funny-alarm-317531.wav
```

## Folder Description
- `src`: Contains the source code.
- `resources`: Contains static resources (e.g., `.wav` files).
- `README.md`: Project documentation.

## Requirements
- Java 8 or higher
- Terminal / Command Prompt

## Check Java version:
```bash
java -version
```

## How to Compile and Run
### Compile
From project root directory:
```bash
javac -g -d bin src/*.java
```
### Run
```bash
java -cp bin Main
```

## Audio Format
The program uses `.wav` format for alarm sound.

## Notes
- If the entered time is earlier than current time, the alarm will be scheduled for the next day.
- Ensure the `.wav` file exists in the correct directory.
- The program uses **Thread.sleep()** to wait until alarm time.

## Technologies Used

- **Core Language**: Java 8+
- **Time & Scheduling**: java.time API
- **Concurrency**: Thread & Runnable
- **Audio Processing**: Java Sound API

## Future Improvements
- GUI version (JavaFX / Swing)
- Multiple alarms support
- Snooze feature
- Background execution
- Custom alarm sound selection

## Learning Outcome
This project serves as a foundational step toward building more advanced time-based or event-driven applications.

## License
This project is licensed under the **MIT License**. See the `LICENSE` file for details.

--- 

If you find this repository useful, feel free to star it.   