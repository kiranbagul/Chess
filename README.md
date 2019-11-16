# CHESS

Simulates a chessboard and the
movements of various types of pieces on the chessboard

### Objective

Program simulates the movement of each unique chess piece on an
empty chessboard.
- Input – input string is Type of chess piece and
its Position (cell number) on the chessboard. E.g. “King D5”
- Output – a string of all
possible cells in which the chess piece can move.

### How to build

#### Prerequisites 
- java 8
- maven

> mvn clean install

#### Execute 

> java -jar target/chess-application-1.0-jar-with-dependencies.jar "King D5" 
  `C4, C5, C6, D4, D6, E4, E5, E6`

Or

> ./run.sh "King D5" 
  `C4, C5, C6, D4, D6, E4, E5, E6`
