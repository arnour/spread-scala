.PHONY: clean test

clean:
	sbt clean
test:
	sbt clean compile +test