package org.example.ex01

// 조건문
// if 문으로 선택하기

fun max(a: Int, b: Int): Int {
    if (a > b) return a
    else return b
}

// !! 코틀린은 if 를 식 (값을 만들어냄) 으로 사용할 수 있다.
fun max2(a: Int, b: Int) = if(a>b) a else b

// if 블록에 여러 문장이 있어도 맨 마지막 식이 블록의 최종 값이 된다.
//val result = if (i >= 0) {
//    val a = s.substring(0, i).toInt()
//    val b = s.substring(i + 1).toInt()
//    (a / b).toString()   // 이 값이 if 블록의 '결과값'
//} else {
//    ""
//}
// if 를 식으로 쓸때에는 반드시 else 가 필요하다. (단순 조건문으로 사용할 때 재외)


// !! 코틀린은 3항 연산자가 없다. 하지만 if 를 식으로 사용할 수 있기 때문에, 상쇄함

// if 식에서 return 을 사용하면 존재하지 않는 값을 뜻함 Nothing
// return의 타입은 Nothing
// 프로그램의 순차적 제어 흐름이, 그부분에서 잘 끝나되, 어떤 잘 정의된 값에 도달하지 못함
// Nothing 타입은 코를린 타입의 하위 타입으로 간주됨 그래서 if 식 안에 return을 넣어도 타입 오류가 나지 않는다.

// Unit vs Nothing -> Unit 은 값이 하나 있는 타입(딱 하나의 인스턴스, 값이 있다는 뜻), Nothing 값이 절대 존재할 수 없는 타입
//이 함수는 절대 값을 반환하지 않는다 → 끝나지 않는 함수 → Nothing.


// 범위, 진행, 연산
// 순서가 정해진 값 사이의 수열을 표현하는 몇가지 타입을 제공함  -> for 루프로 수의 범위를 반복해야할때 유용함.

// 범위를 만드는 방법 ".. 연산자 사용하기 "
val chars = 'a' .. 'h'
val twoDigits = 10..9

// "in" 연산을 사용하면 어떤 값이 범위 안에 있는지 알 수 있음
//val num = readLine()!!.toInt()
//println(num in 10..9)

// "!in" 연산도 있음
// println(num !in 10..9)

// 수타입, Char, Boolean, String 등 모든 비교가능한 타입에 대해 .. 연산을 사용 가능
// <= >= 를 사용할 수 있는 타입이라면 ㅇㅇ

// .. 연산에 의해 만들어지는 범위는 닫혀있다 (시작값 - 끝값이 포함된다는 뜻)


// "상계" "until"
// 하지만 반만 닫힌 범위를 만들 수 있다.
// 정수에만 사용 가능 , 끝값보다 1 작은 값까지 만듬
val twoDigits2 = 10 until 100 // 10~99

// 5 until 5 -> false (빈 범위)

// "추이적" 비교연산이 제대로 작동하지 않으면, 이런 특징이 성립하지 않음
//a < b  그리고  b < c  이면  a < c
//같은 범위를 생성할 때 코틀린은 내부적으로 “시작 값 < 끝 값” 같은 비교를 반복적으로 수행한다.
//만약 비교의 추이성이 깨지면(예: custom compare가 이상하게 구현됨):

// "진행" Progression 간격 만큼 떨엊져 있는 정수, Char 값으로 이루어진 시퀀스
/*Kotlin에서는 다음과 같은 타입들이 존재한다:
IntProgression
LongProgression
CharProgression
이들은 모두:
시작(start)
끝(end)
간격(step)*/
// println(5 in 10 downTo 1) // true
// println(5 in 1 downTo 10) /false : 빈 진행
// "downTo" 내려가는 진행을 만들 수 있다.

// 1..10 step 3 // 1 4 7 10
// 15 downTo 9 step 2 // 15 13 11 9
// "step" 간격 지정도 가능
// 진행 간격은 양수여야한다. 진행 자체를 만들 때에도 양수를 써야한다.

// 1..12 step 3 //1,4,7,10
// 끝 값이 진행에 속한 원소가 아닐 경우, 자동으로 끝 값에 가까운 값까지만 진행에 속하게 된다.




