package object infrastructure {

  type ErrorOr[T] = Either[Throwable, T]
}
