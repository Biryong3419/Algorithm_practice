//import java.util.*
//
//class NCodilityTest1 {
//    fun solution(S: String, L: Array<String>): Int {
//        // write your code in Kotlin 1.3.11 (Linux)
//
//        val myMap = HashMap<Char, Int>()
//        for(c in S.toCharArray()){
//            if(myMap[c] == null) {
//                myMap[c] = 0
//            }
//            myMap[c] = myMap[c]!! + 1
//        }
//
//        var maximumBuild = 0
//
//        for(str in L) {
//            val tmpMap = HashMap(myMap)
//            var count = 0
//            while(true) {
//                var breakFlag = false
//
//                for(c in str) {
//                    if(tmpMap[c] != null && tmpMap[c]!! > 0) {
//                        tmpMap[c] = tmpMap[c]!! - 1
//                    } else {
//                        breakFlag = true
//                        break
//                    }
//                }
//                if(breakFlag) {
//                    break
//                }
//                count++
//            }
//            if(maximumBuild < count) {
//                maximumBuild = count
//            }
//        }
//        return maximumBuild
//    }
//
//}
//
//fun main() {
//    val n = NCodilityTest1()
//    n.solution("BILLOBILLOLLOBBI", arrayOf("BILL", "BOB"))
//}
//
//import java.util.*
//
//class NCodilityTest2 {
//    fun solution(A: IntArray, R: Int): Int {
//        var max = 0
//        for(i in 0..A.size-R) {
//            val aList = ArrayList(A.toList())
//            aList.subList(i, i+R).clear()
//            val setSize = aList.toSet().size
//            if(setSize > max) {
//                max = setSize
//            }
//        }
//        return max
//    }
//}
//
//fun main() {
//    val n = NCodilityTest1()
//    n.solution(intArrayOf(2,3,1,1,2), 2)
//}
//
//import java.util.*
//
//class NCodilityTest3 {
//    var BB = arrayOf("hungry")
//    val dx = arrayListOf(0, 1, 0, -1)
//    val dy = arrayListOf(1, 0, -1, 0)
//
//    fun solution(B: Array<String>): IntArray {
//        BB = B.clone()
//        var a = 0
//        var b = 0
//        var c = 0
//
//        for(i in B.indices) {
//            for(j in B[i].indices) {
//                //println("current => $i, $j")
//                if(BB[i][j] == '#') {
//                    dfs(j, i, 0)
//                    //println("i:$i, j:$j, depth:$hiDepth")
//                    if(hiDepth == 3) {
//                        c++
//                    } else if(hiDepth == 2) {
//                        b++
//                    } else if(hiDepth == 1) {
//                        a++
//                    }
//                    hiDepth = 0
//                }
//            }
//        }
//        return intArrayOf(a, b, c)
//    }
//
//    var hiDepth = 0
//    fun dfs(x: Int, y: Int, depth: Int) {
//        if(x < 0 || x >= BB[0].length || y < 0 || y >= BB.size) {
//            return
//        }
//        if(BB[y][x] != '#') {
//            return
//        }
//        replaceChar(y, x, '0')
//        //println("current x:$x y:$y depth:$depth")
//        hiDepth++
//        for(i in 0..3) {
//            val nx = x + dx[i]
//            val ny = y + dy[i]
//
//            if(nx >= 0 && ny >= 0 && nx < BB[0].length && ny < BB.size) {
//                if(BB[ny][nx] == '#'){
//                    dfs(nx, ny, depth+1)
//                }
//            }
//        }
//    }
//    fun replaceChar(i: Int, j: Int, rChar: Char) {
//        val b = StringBuilder(BB[i])
//        b.setCharAt(j, rChar)
//        BB[i] = b.toString()
//    }
//}
//
//fun main() {
//    val n = NCodilityTest1()
//    println("result => ${n.solution(arrayOf("##.", "#.#", ".##"))}")
//}