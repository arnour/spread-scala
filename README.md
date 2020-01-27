# spread-scala

A library to calculate hashed-based key almost-even random distribution

[![Build Status](https://travis-ci.org/arnour/spread-scala.svg?branch=master)](https://travis-ci.org/arnour/spread-scala)

## Installation

    

## Example Usage

```scala
// Create a spread instance
val spreader = Spread.newSpreader("SHA-256")

// you could also use different hash implamentations
// val spreader = Spread.newSpreader("SHA-1")

val keyValue = "my-key-to-hash"

val fraction = spreader.key(keyValue)

println(fraction) // 0.804535691348
```

### Testing

    $ make test