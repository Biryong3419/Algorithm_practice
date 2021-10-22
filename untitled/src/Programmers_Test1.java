//package com.msp.booking_service.domain.v11
//
//import java.lang.StringBuilder
//import java.util.ArrayList
//
//class Test {
//    fun solution(registered_list: Array<String>, new_id: String): String {
//        val registeredMap = HashMap<String,ArrayList<Int>>()
//        for(str in registered_list) {
//            val s = StringBuilder()
//            val n = StringBuilder()
//            for(c in str) {
//                if(!c.isDigit()) {
//                    s.append(c)
//                } else {
//                    n.append(c)
//                }
//            }
//            if(registeredMap[s.toString()] == null) {
//                registeredMap[s.toString()] = ArrayList()
//            }
//            if(n.isNotEmpty()) {
//                val num = n.toString().toInt()
//                registeredMap[s.toString()]!!.add(num)
//            } else {
//                registeredMap[s.toString()]!!.add(0)
//            }
//        }
//
//        val s = StringBuilder()
//        val n = StringBuilder()
//        for(c in new_id) {
//            if(!c.isDigit()) {
//                s.append(c)
//            } else {
//                n.append(c)
//            }
//        }
//        var num = if(n.isEmpty()) {
//            0
//        } else {
//            n.toString().toInt()
//        }
//
//
//        if(registeredMap[s.toString()] == null) {
//            return new_id
//        }
//
//
//        if(registeredMap[s.toString()] != null) {
//            if (registeredMap[s.toString()]!!.isEmpty()) {
//                return new_id
//            }
//
//            while(true) {
//                if(registeredMap[s.toString()]!!.contains(num)){
//                    num++
//                } else {
//                    if(num == 0) {
//                        return "${s}"
//                    } else {
//                        return "${s}${num}"
//                    }
//
//                }
//            }
//        }
//        return ""
//    }
//}
//
//    fun main() {
//        val t = Test()
//        val result = t.solution(arrayOf("cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"), "cow")
//        println("result => $result")
//    }
//
//
//    package com.msp.booking_service.domain.v11
//
//class Test2 {
//    val dayList = arrayListOf("MON", "THU" , "WED", "THU","FRI","SAT","SUN")
//    var offsetIdx = 0
//    fun solution(leave: Int, day: String, holidays: IntArray): Int {
//
//        offsetIdx = dayList.indexOf(day)
//
//        var maximumLeave = 0
//        for(i in 1..30) {
//            var count = 0
//            var tmpLeave = leave
//            for(j in i..30) {
//                val today = getToday(j)
//                if(today == "SUN" || today == "SAT" || holidays.contains(j)) {
//                    count ++
//                    if(j == 30) {
//                        if(count > maximumLeave) {
//                            maximumLeave = count
//                        }
//                    }
//                } else {
//                    if(tmpLeave == 0) {
//                        if(count > maximumLeave) {
//                            maximumLeave = count
//                        }
//                        break
//                    }
//                    tmpLeave --
//                    count++
//                }
//            }
//        }
//        var answer: Int = maximumLeave
//        return answer
//    }
//    fun getToday(today: Int):String {
//        var newToday = today % 7
//        if(newToday == 0) {
//            newToday = 7
//        }
//        if(newToday + offsetIdx > 7) {
//            return dayList[newToday+offsetIdx - 7 - 1]
//        } else {
//            return dayList[newToday+offsetIdx - 1]
//        }
//    }
//}
//
//    fun main() {
//        val t = Test2()
//        println(t.solution(4, "FRI", intArrayOf(6,21,23,27,28)))
//    }
//