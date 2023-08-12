package com.example.videoplayer.core.abstraction



interface OneWayMapper<in Before, out After> {
    fun map(before: Before) : After
    fun mapList(before: List<Before>) : List<After> = before.mapTo(mutableListOf(), ::map)
}