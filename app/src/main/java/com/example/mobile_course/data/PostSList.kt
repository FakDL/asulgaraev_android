package com.example.mobile_course.data

import com.example.mobile_course.models.PostS

object PostSList {
    var list: ArrayList<PostS> = arrayListOf(
        PostS(1, "RRR", "bababooey"),
        PostS(2, "LOL", "14785236"),
        PostS(3, "ERR", "goblin")
    )

    fun findPostSById(id: Int): PostS {
        for (post in list) {
            if (post.id == id) {
                return post
            }
        }
        return PostS(0, "","")
    }
}
