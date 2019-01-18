package com.mpc.scalats.configuration

import java.io.PrintStream

/**
  * Created by Milosz on 09.12.2016.
  */
case class Config(
    emitInterfaces: Boolean = true,
    emitClasses: Boolean = false,
    optionToNullable: Boolean = true,
    optionToUndefined: Boolean = false,
    outputStream: Option[PrintStream] = None,
    prependIPrefix: Boolean = true,
    typescriptIndent: String = "\t",
    emitCodecs: Boolean = true,
    fieldNaming: FieldNaming = FieldNaming.Identity
)

// TODO: nullable as function setting (gathering optionToNullable/optionToUndefined)
// TODO: option as space-lift Option
// TODO: prelude: String
// TODO: Per-type options: nullable, fieldNaming, emitCodecs, prelude
