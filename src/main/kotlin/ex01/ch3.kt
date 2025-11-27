package org.example.ex01

import kotlin.math.PI

    // 함수

    fun circleArea(radius: Double): Double {
        return PI * radius * radius;
    }

    fun main() {
        print("Enter radius: ")
        val radius = readLine()!!.toDouble()
        println("The sum is: ${circleArea(radius)}")
    }

    // fun -> function , 컴파일러에게 함수 정의가 뒤따라옴을 알림
    // 변수 이름과 마찬가지로, 아무 식별자-함수이름으로 쓸 수 있음.
    // 괄호로 둘러쌓인 파라미터 목록 -> ()
    // 반환타입 -> 함수를 호출한 쪽에게 돌려줄 반환값
    // 함수의 본문  ->  {}


    // 함수가 파라미터를 받지 않아도 괄호는 필수

    fun readInt(): Int{
        return readLine()!!.toInt()
        val x = 3
    }

// 결과 값은  retrun 으로 지정
// !! 자바와 달리, "도달할 수 없는 코드"는 오류가 아니고, 경고로 표시함

//블록 문 {} , 새줄로 분리 or 세미콜론으로 분리 -> 한문장이라도 {} 로 묶는다.

// 자바 메서드 디폴트가 가변 -> 내부에서 변경하지 못하게 final 을 지정해야함
// 하지만 코틀린의 함수 파라미터는 무조건 불변 -> 본문에서 변경하면 컴파일 오류
//  파라미터 앞에 val , var 표시 할 수 없음

// 값에 의한 호출 -> 파라미터 값에 호출하는 쪽의 인지를 복사
// 호출 인자로 전달한 변수를 변경해도, 내부 파라미터 값에는 영향이 없다.
// ㅇ배열의 경우에는 참조만 복사된다.
//기본 타입
//→ 실제 값이 복사되므로 원본 절대 안 변함.
//
//배열/객체
//→ 참조가 복사되므로
//“참조는 다른 변수지만, 가리키는 대상은 같음”.
//→ 그래서 내부 데이터는 바뀔 수 있음.
//
//그래도 Call by Value임.
//Call by Reference가 아님.
//참조를 값으로 복사한 것뿐.

// 파라미터에는 항상 타입을 지정해야한다. -> 컴파일러는 파라미터 타입을 추론하지 못한다.

// 반환타입은 함수 파라미터에서 추론이 가능하지만 -> 명시해야한다.
// 외부로 나가는 값이 여러 곳일 수 있기 때문이다.

// 1. 유닛타입을 반환 (void) 를 반환하는 경우 -> 생략 가능
// Unit 이라는 내장 타입에 속하는 상수를 반환한다.
// 함수에서 반환값 타입을 지정하지 않으면 , Unit 함수를 정의한다고 가정함

//fun prompt(name: String) {
//    println("Your name is $name")
//}
//
//fun prompt(name: String): Unit{
//    println("Your name is $name")
//}

//Unit 함수는 결과가 항상 Unit 으로 동일하기 때문에 return 이 필요 없지만
// 함수 본문의 끝에 도달하기전 끝내려면 retrun 을 사용해서 끝내야한다.

//2. 식이 본문인 함수
// 어떤 함수가 단일 식으로 구현될 수 있으면 return, 블록의 {} , 생략해서 함수를 작성한다

fun circleArea2(radius: Double): Double = PI*radius * radius;
fun circleArea3(radius: Double) = PI*radius * radius;

// = 기호는 변수를 초기화하는 식을 지정햇던 변수 정의와 비슷함
// 식이 본문인 함수에서도 반환값 생략 가능

fun g(x: Int) = { x * 2 }
//val g: (Int) -> (() -> Int)
//val result = g(10)   // result는 함수
//println(result())    // 이때 비로소 20 출력

// but, 블록으로 이루어진 함수를 정의할때 = 를 쓰게되면 익명 함수 (람다) 로 해석되기 떄문에 주의

fun circelArea4(radius: Double) = {PI * radius * radius}

//fun circelArea5(radius: Double) = {
//    return PI * radius * radius
//}
// 식이 본문인 함수에서 retrun 금지

// 2. 위치 기반 인자와 이름 붙은 인자
// 함수 호출 인자는 순서대로 파라미터에 전달된다.
// 이러한 방식을 "위치 기반인자" 라고 한다.
// 반면 코틀린은 "" 이름 붙은 인자" 라고 불리는 방식도 제공한다.
// 파라미터 이름을 명시함으로써 인자를 전달하는 방ㅅ기이다

//rectangleArea(width = w, height = h)
//rectangleArea(height =h , width = w)
// 이름 붙은 인자를 사용하면 파라미터의 순서는 중요하지 않다.

// 함께 사용도 가능하다.
// but 이름붙은 인자를 사용하기 시작하면 전부 작성해야하는데....
// 이 경우에는 원래 인자가 들어가야할 위치에 지정해야 정상 처리 된다.
//swap (s = "hello", 2, 1) // 1.4 이전 버전은 컴파일 오류

// 1.4 이후부터는 둘다 사용 가능해짐
// swap(from =1, s ="hello", to = 2)

// 3. 오버로딩과 디폴트 값
// 자바 메서드와 동일하게 , 오버 로딩 가능
// = 컴파일러가 구분할 수 있도록 오버로딩한 함수의 파라미터 타입이 모두 달라야함

fun readEx() = readLine()!!.toInt()
fun readEx(radix: Int) = readLine()!!.toInt(radix)

// 호출 식에 대해 실제 호출할 함수를 결정할 때, 컴파일러는 " 자바 오버로딩 해소 규칙 " 을 따른다.
// 1. 파라미터 개수, 타입을 기준으로 호출할 수 있는 모든 함수를 찾음
// 2. 덜 구체적인 함수를 제외시킴,  파라미터 ㅇ타입이 상위타입인 경우 덜 구체적임 -> 구체적을 찾기 위해 게속 반복
// Any 가 아닌 Int 를 실행
fun mul(a: Int, b:Int) = a*b
fun mul(o: Any, n:Int) = Array(n) {o}
// 덜 구체적인 함수로 호출하고 싶으면 as 타입 캐스팅 연산자를 통해 상위타입으로 명시적 변환을 한다.
//    mul("0" as Any, 3)

// 3. 후보가 하나로 압축되면 호출 함수 , 둘 이상이면 컴파일 오류

//fun readInt(base: Int = 10): Int {
//    // base 진법으로 읽어온다…
//}

// 디폴트 파라미터
// 디폴트 파라미터를 지정하지 않고 호출하는 방법
 fun printNumber(base: Int = 10) {
    println(base)
}
//printNumber()    // base에 10이 자동으로 들어감
//printNumber(5)   // base = 5

// 디폴트 파라미터 뒤에 디폴트가 지정되지 않은 파라미터가 있는 경우,  "이름 붙은 인자"를 사용하는 것
//printNumber(base = 8)
// !! 디폴트 값이 있는 파라미터를 함수 인자 목록 뒤에 몰아두는 것이 더 좋은 코딩이다.

fun mul2(a: Int, b: Int = 1) = a*b //1
fun mul2(a: Int, b: Long = 1L) = a*b
fun mul2(a: Int, b: Int, c: Int = 1) = a*b*c
// 기본적으로 mul2(1,2) ->  인자가 적은 쪽을 1번 먼저 호출
// 1번을 fun mul2(a: Number, b:Int =1) = a*b // 덜 구체적인 함수로 간주
// 로 바꾸게 되면, Number 가 Int 상위타입이 되어서 3번째 함수로 호출됨


// 4. vararg 가변 인자 (바라그)
//파라미터의 개수를 마음대로 받을 수 있게 해주는 키워드.
fun sum(vararg nums: Int) {
    // nums는 IntArray 로 들어온다
}
//sum(1, 2, 3, 4)
//sum(10)
//sum()
// 파라미터 정의 앞에 vararg 변경자를 붙이기

val arr = intArrayOf(1,2,3)
//sum(*arr)
//sum(1,2,3) 으로 취급됨
// 정수 가변인자에는 배열을 못 넣음 -> 배열 객체 하나만 받아서 오류 남
// 배열을 “풀어줘야” 함 → * 연산자
// 스프레드연산자  * -> 배열을 가변 인자 대신 넘길 수 있음 => 배열을 복사함
// 얕은 복사가 이루어진다. 내부에 참조가 복사되기 때문에 함수 내부 배열에서 공유됨.

// 둘 이상을 vararg 파라미터로 선언 불가,  -> 가변 인자 자리에 들어가야 하는 건 각각의 정수임.
// 콤마로 분리한 여러 인자와 스프레드를 섞어 전달하는 것은 괜찮음

// vararg 파라미터가 맨 마지막에 있는 파라미터가 아니면,
// 이후 파라미터는 무조건 이름 붙은 인자로만 전달해야 한다.
//fun printAll(vararg words: String, prefix: String)
//printAll("a","b","c", prefix="※")  // O
//printAll("a","b","c", "※")         // X
//!! vararg 도 파라미터 목록 맨뒤에 위치시키는 것으 좋은 코딩

// vararg 파라미터를 이름 붙은 인자로 전달 할 수 없음

// 디폴트 값이 있는 파라미터 , vararg 섞어 사용하는 것은 어려움
// 디폴트를 vararg 앞에 두면 파라미터로 전달될 값이 디폴트로 가게됨
//fun test(defaultValue: Int = 1, vararg nums: Int)
//test(5, 6, 7) ?????  구분이 안 됨.
// vararg를 항상 맨 뒤에 두기
//test(defaultValue = 3, nums = *intArrayOf(1,2))
// vararg 파라미터를 이름 붙은 인자 스프레드를 사용해서 전달

//fun show(vararg items: Int, end: String = "끝")
//show(1,2,3, end = "!")
// vararg 파라미터 뒤에 디폴트 파라미터가 있는 경우 , 디폴트 파라미터를 이름붙은 인자로 호출해야함 !!

// 오버로드 규칙으로 동일 타입 파라미터 수가 고정되어있는 함수보다 "덜 구체적인 함수"로 간주됨.


// 5. 함수 영역과 가시성
// 1. 파일에 직접 선언된 최상위 함수
// 2. 어떤 타입 내부에 선언된 멤버 함수
// 3. 다른 함수 안에 선언된 지역 함수

// 디폴트로 최상위 함수는 -> public 공개 함수
// private, internal 키워드 -> "가시성 변경자"
// -> private 비공개 로 설정하면 다른 파일에서 사용 불가
// -> internal 내부 로 설정하면 함수가 적용된 모듈 내부에서만 함수 사용
// 모듈 : 함께 컴파일 되는 파일 전부 (프로젝트 모듈 내의 파일을 모으는 빌드 시스템에 따라 달라짐)
// 같은 모듈에 속한 다른 파일에서는 이 함수를 사용할 수 있지만, 다른 모듈에서는 사용 불가
// -> public 공개 로 설정하면, 디폴트가 공개기 때문에 불필요한 중복 이다.

// 지역 함수 -> 자신을 둘러싼 함수 , 블록에 선언된 변수,함수에 접근 가능
//가시성 변경자는 붙일 수 없다.

// 패키지 : 이 파일이 어디 속하는지 정하는 것
// 같은 패키지 안에서는 이름만 써도 된다.

// 패키지가 다르면 전체이름으로 접근해야한다. foo.bar.util.readInt(10)
// 해결법 : import foo.bar.util.readInt 임포트 시키기
// "패키지 디렉티브" -> 여러 파일을 같은 패키지에 넣을 수 있음 -> package foo.bar


// 패키지 이루는 최상위 선언 -> 타입, 함수, 프로퍼티
/*
package foo.bar

fun hello() { ... }      // 최상위 함수
val a = 10               // 최상위 프로퍼티
class User { ... }       // 최상위 타입(클래스)
*/
// 파일 자체의 최상단에서 선언 가능
// 코틀린이 자바와 다르게 “최상위 함수/프로퍼티”를 허용함


// 패키지 계층 구조
// 소스파일에 있는 패키지 디렉티브로 부터 별도의 구조이다
// 소스파일 - 패키지 계층 구조가 동일할 수도 있지만, 그럴필요 없음
// 소스파일은 한디렉터리 아래에 있지만, 다른 패키지에 포함될 수 있고, 한패키지에 포함된 소스 파일이 다른 디렉터리로 갈 수 있음
// !! 자바는 패키지구조,소스트리디렉터리 구조가 같아야한다. (경로가 다르면 컴파일 오류)
// 디렉터리, 패키지 구조를 동일하게 하는 것을 권장함.

// 임포트 디렉티브
// 전체이름을 사용하지 않아도 임포트 가능하다.
// 클래스 안의 클래스, 상수 등도 임포트 가능
// import kotlin.Int.Companion.MIN_VALUE
// !! 코틀린은 타입 멤버를 임포트하는 import static 티렉티브가 없다,
// 코틀린의 모든 선언은 일반적인 임포트 디렉티브 구문을 사용해 임포트할 수 있다.

//import app.util.foo.readInt
//import app.util.bar.readInt
// 임포트 별명
// 임포트 함수명이 같은 경우, as 를 통해서 구분한다.
//import foo.readInt as fooReadInt
//import bar.readInt as barReadInt

// import kotlin.math.*
//이런 형태의 필요시 임포트(import-on-demand) 기능은 구체적인 선언을 지정해 임포트하는 디렉티브보다 우선순위가 낮다.

//import app.util.foo.readInt
//import app.util.bar*
// 이 경우에는 같은 readInt 를 사용해도 구체적인 선언가 더 우선순위로 된다.
// 즉 foo.readInt 가 호출됨

