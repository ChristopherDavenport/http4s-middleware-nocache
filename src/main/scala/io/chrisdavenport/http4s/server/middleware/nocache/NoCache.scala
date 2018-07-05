package io.chrisdavenport.http4s.server.middleware.nocache

import cats.Functor
import cats.data.{Kleisli, NonEmptyList}
import org.http4s.{CacheDirective, Header, HttpService}
import org.http4s.headers.`Cache-Control`

object NoCache {
  def apply[F[_]: Functor]: HttpService[F] => HttpService[F] = { service: HttpService[F] =>
    Kleisli { req =>
      val noCacheHeader: Header = `Cache-Control`(NonEmptyList.of(CacheDirective.`no-cache`()))
      service(req).map(resp => resp.copy(headers = resp.headers.put(noCacheHeader)))
    }
  }
}
