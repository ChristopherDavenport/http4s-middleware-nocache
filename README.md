# http4s-middleware-nocache [![Build Status](https://travis-ci.com/ChristopherDavenport/http4s-middleware-nocache.svg?branch=master)](https://travis-ci.com/ChristopherDavenport/http4s-middleware-nocache) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/http4s-middleware-nocache_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/http4s-middleware-nocache_2.12)

This is a middleware that adds a `Cache-Control: no-cache` to every response returned by the `HttpService[F]`.

Care should be taken that all responses are correctly calculated as it will allow any unmatched responses through without modification.

## Quick Start

To use http4s-middleware-nocache in an existing SBT project with Scala 2.11 or a later version, add the following dependency to your
`build.sbt`:

```scala
libraryDependencies += "io.chrisdavenport" %% "http4s-middleware-nocache" % "<version>"
```

## Examples

First some imports

```tut:silent
import org.http4s._
import org.http4s.dsl.io._
import io.chrisdavenport.http4s.server.middleware.nocache.NoCache
```

```tut

val service = HttpService[IO]{
  case GET -> Root => Ok()
}

val req = Request[IO](Method.GET, Uri.uri("http://localhost:8080"))

val result = service(req)

result.unsafeRunSync
```