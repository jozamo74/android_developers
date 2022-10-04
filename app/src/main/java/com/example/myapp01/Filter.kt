package com.example.myapp01

/****
 * Project: My app01
 * From: com.example.myapp01
 * Created by José Zambrano Moya on 4/10/22 at 16:05
 * More info: zambranomoya74@gmail.com
 ****/
sealed class Filter {
    object None: Filter()
    class ByType(val type: MediaItem.Type): Filter()
}
