package com.globoplay.gvictorino.domain

abstract class UseCase<out T> {
    abstract fun execute() : T
}
