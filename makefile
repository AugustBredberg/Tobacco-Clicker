
all:
	javac -d classes *.java

run:
	java -cp classes game.Game

clean:
	rm *.*~
