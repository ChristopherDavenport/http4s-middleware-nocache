# http4s-middleware-nocache [![Build Status](https://travis-ci.com/ChristopherDavenport/http4s-middleware-nocache.svg?branch=master)](https://travis-ci.com/ChristopherDavenport/http4s-middleware-nocache) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/http4s-middleware-nocache_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/http4s-middleware-nocache_2.12)

This is a middleware that adds a `Cache-Control: no-cache` to every response returned by the `HttpService[F]`.

Care should be taken that all responses are correctly calculated as it will allow any unmatched responses through without modification.