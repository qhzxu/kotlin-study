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

//"Hello, World".subString(1..4) // ello
//IntArray(10) {it*it}.sliceArray(2..5) // 4,9,16,25
// 인덱스 * 인덱스 값을 10 배열크기로 만들어서, 인덱스 2부터 5까지 포함하는 범위를 잘라서 새 배열로 반환.
// 범위를 사용해서 문자열, 배열의 일부를 뽑아낼 수 있음

// 범위는 동적으로 할당되는 "객체" 이기 떄문에, 비교 대신 범위를 쓰면 부가 비용이 든다.

// 코틀린 코드가 실제로 JVM에서 어떻게 돌아가는지 확인하고 싶을 때 사용하는 기능
// 코틀린 코드의 저수준 의미를 알아보고 싶을 때 - >
// JVM 바이트 코드 뷰어 -> Tools > Kotlin > Show Kotlin ByteCode 를 선택

// in / !in 연산은 범위뿐 아니라 “포함 관계를 표현하는 타입”이면 다 사용 가능하다
// 범위(..)는 반드시 객체를 생성하는가? -> 컴파일러는 필요 없으면 범위 객체를 만들지 않는다.

//println(5 in a..b)
// a <= 5 && 5 <= b 로 최적화 됨

// 연산자 우선순위 ".." 범위 연산자는 "+" 보다 낮고, "비교" 보다는 높다.
// "in / !in" 은 "논리연산자" 사이에 위치


// when 문과 여럿 중에 하나 선택하기
// !! 코틀린은 if 로 조건을 순차적 검사하는 것을 -> when 문으로 쉽게 가능

fun hexDigit(n: Int): Char {
    when{
        n in 0..9 -> return '0' + n
        n in 10..15 -> return 'A' + n - 10
        else -> return '?'
    }
}

// 조건 → 문(branch) 형태가 여러 개 나올 수 있음.
// else는 선택 사항 (디폴트 가지(default branch)) -> 없어도 됨. 대신 그 경우, 조건을 만족하는 게 하나도 없으면 아무 일도 안 하고 when 블록이 끝남
// 위에서 아래로 첫 번째로 일치하는 가지만 실행됨. -> 나머지는 무시함
//

// when 문도 if 처럼 사용 가능, 모든 가능한 경우에 대한 값을 만들기 위해 else 를 꼭 포함
// when을 식(expression)으로 사용할 때는 else 필수

// when 은 자바 switch 문과 비슷하지만, when은 switch보다 훨씬 범용적
//switch는 "값이 일치하는지"만 비교 가능.
//when은 조건식이 자유로움: 범위, 타입 체크, Boolean 식 등 뭐든 가능.

// switch의 fall-through(풀 스루) :
// 어떤 조건을 만족할 때 까지 프로그램이 해당 조건에 대응하는 문을 실행하고 break 를 만날때까지 모든 가지를 실행
// when 은 조건을 만족하는 가지만 실행하고 절대 플스루 하지 않음 -> break 필요 없음.


// 대상이 있는 when

fun numberDescription(n: Int): String = when {
    n == 0 -> "Zero"
    n == 1 || n == 2 || n == 3 -> "Small"
    n in 4..9 -> "Medium"
    n in 10..100 -> "Large"
    n !in Int.MIN_VALUE until 0 -> "Negative"
    else -> "Huge"
}

// “n 값을 기준으로 분기하겠다”
// 각 가지(condition)는 n과 비교되는 값이어야 함
fun numberDescription(n: Int, max: Int = 100): String = when (n) {
    0 -> "Zero"
    1, 2, 3 -> "Small"
    in 4..9 -> "Medium"
    in 10..max -> "Large"
    !in Int.MIN_VALUE until 0 -> "Negative"
    else -> "Huge"
}
