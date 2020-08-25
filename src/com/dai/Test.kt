package com.dai

import java.lang.Exception


fun test() {
    //高度
    val high = 25
    val loves = "loveHaoHuiJieLoveHaoHuiJieLoveHaoHuiJieLoveHaoHuiJieLoveHaoHuiJie"
    val length = loves.length / 5
    //边界
    val margin = 9
    //长度
    val width = margin * 2 + loves.length
    println()
    println()
    val totalSb = StringBuilder()
    for (i in 0..high) {
        val sb = StringBuilder()
        for (j in 0..width) {
            if (j >= margin && j < width - margin) {
                when {
                    i in 0..2 -> {
                        appendOne(sb, loves, j, i, length, margin)
                    }
                    i in 3..10 -> {
                        appendTwo(sb, loves, j, i, length, margin)
                    }
                    i > 10 -> {
                        appendThree(sb, loves, j, i - 10, length, margin)
                    }
                }
            } else {
                sb.append(" ")
            }
        }

        totalSb.append(sb).append("~")
//        println(sb)
    }
    val thread = Thread {
        Thread.sleep(2000)
        for (i in 0..(totalSb.length)) {
            try {
                val value = totalSb[i].toString()
                if ("~".equals(value)) {
                    println()
                } else if (" ".equals(value)) {
                    print(value)
                } else {
                    Thread.sleep(20)
                    print(value)
                }
            } catch (e: Exception) {

            }

        }
        println()
        println("                         爱你（づ￣3￣）づ╭❤～ 宝贝"                       )
        println()

    }
    thread.start()



}

private fun appendOne(
        sb: StringBuilder,
        loves: String,
        j: Int,
        index: Int,
        length: Int,
        margin: Int
) {
    val value = margin * 5 / 3
    if (j <= (length / 2 - index * 2) + value ||
            (j >= ((length * 3 / 2 + index * 2) + value) && j < (((length * 5 / 2 - index * 2) + value))) ||
            j >= (length * 7 / 2 + index * 2) + value
    ) {
        sb.append(" ")
    } else {
        sb.append(loves[j - margin])
    }
}

private fun appendTwo(
        sb: StringBuilder,
        loves: String,
        j: Int,
        index: Int,
        length: Int,
        margin: Int
) {
    val value = margin * 5 / 3
    if (j <= (length / 2 - index * 2.2) + value ||
            j >= (length * 7 / 2 + index * 2.2) + value
    ) {
        sb.append(" ")
    } else {
        sb.append(loves[j - margin])
    }
}

private fun appendThree(
        sb: StringBuilder,
        loves: String,
        j: Int,
        index: Int,
        length: Int,
        margin: Int
) {
    val value = margin * 5 / 3
    if (j <= length / 2 + index * 2.2 ||
            j >= (length * 9 / 2 - index * 2.2) + value + 1
    ) {
        sb.append(" ")
    } else {
        sb.append(loves[j - margin])
    }
}

