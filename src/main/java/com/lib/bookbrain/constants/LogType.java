package com.lib.bookbrain.constants;

import lombok.Getter;

@Getter
public enum LogType {
   C("create"),         //
   U("update"),         //
   R("select"),         //
   D("delete"),         //
   ;


private final String value;

LogType(String value) {
   this.value = value;
}
}
