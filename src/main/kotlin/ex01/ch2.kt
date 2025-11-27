package ex01

import java.util.Date

class ch2 {

    // 1. 주석 방법
    // // or /* or /** */
    // 자바와 달리 여러줄 주석을 내포 가능

    /*
    // 여러줄 주석인가요?
    /* 여러줄 주석 입니다. */
    */

    // 2. 변수 정의 하기

    val timeInSeconds = 15

    // val value 키워드
    // 변수 식별자
    // 변수 초기값

    // 코틀린에서는 세미콜론 생략해도 된다.
    // 세미콜론 쓰지 않는 스타일을 권장 (한줄에 한문장만 넣으면)

    fun main() {
        val a = readLine()!!.toInt()
        val b = readLine()!!.toInt()

        println(a * b)
    }

    // readLine() -> 표준입력에서 한줄 읽어서 문자열로 변환함수
    // !! 널이 아님을 단언 -> readLin() 의 결과가 null 인 경우 예외를 발생 시킴
    // 코틀린은 널이 될 수 있는 값을 추적하고, 널인지 아닌지 화길하지 않은 갓에 대해 toInt() 호출을 막음 -> 널 오류 방지
    // toInt() -> 코틀린 String 클래스가 제공하는 메서드 , 문자열 -> 정수값으로 변환
    // 타입 추론 -> 코틀린은 강한 타입 지정 언어임 + 불필요한 타입 정보를 제외하여 깔끔한 코드를 만듬

    val n: Int = 100
    val text: String = "안녕하세요"

    // 타입을 명시할 수 있음
    // 변수 이름 뒤에 : 를 표시하고 타입을 작성한다.
    // 초깃값이 지정한 타입에 속해야한다.

    // ctrl + shift + P 를 누르면 추론 타입을 볼 수 있음.

//    val text2: String   // 에러 발생
//    text2 = "hello"     // 멤버 val 초기화 불가
    // 클래스 멤버는 선업 후 따로 할당 방식 불가

    // 초깃값을 생략하고 다른 문에서 변수 초기화도 가능.
    // 변수 타입을 명시해야함.


    // 3. 식별자
    // 문자,숫자,_ 만 사용 (숫자로 시작불가)
    // 밑줄로만 이뤄질 수도 있다. _, __, ___ 예약된 식별자라 일반 식별자로는 불가능
    // 하드 키워드를 식별자로 사용 불가

    // 소프트 기워드는 특별한 문맥에서만 키워드로 간주 , 아닌경우에는 사용 가능

    // 코틀린 식별자에서는 $ 를 사용할 수 없다.

    // 원래 식별자로 사용할 수 없는 이름을 “강제로 식별자처럼” 사용하기 위해
    // `` 작은역따옴표 사이에는 빈 문자열을 제외한, 아무 문자도 가능 -> 새줄문자, 작은역따옴표 불가

    val `fun` = 1
    val `name with hi` = 20


    //4. 가변 변수
    // var 가변 변수 정의
    // 원할때 변수 값을 바꿀 수 있다.

    class A {
        var num = 1

        init {
            num = num + 2
        }
    }
    //클래스 본문에서는 실행문(statement) 을 바로 쓸 수 없다.
    // 코틀린 대입은 문 (statement) 이다.
    // 아무값도 돌려주지 않음, 이로인해 코틀린에서 자바의 연쇄 문 사용 x a = b= c


    // 5. 식과 연산자
    // 리터럴  1234
    // 변수/프로퍼티 참조와 함수 호출 a, .length
    // 전위와 후위 단항 연산  --a
    // 이항 연산 a+b

    // 모든 식은 정해진 타입이 있음.
    // 변수참조-함수호출에 . (점) -> 수신객체연산 포함 가능.


    // 6. 기본타입
    // 코틀린에서는 똑같은 타입이 문맥에 따라 원시-참조 타입을 가리킨다. (구분이 자바에 비해 모호함)
    // 코틀린의 모든 타입은 근본적으로 어떤 클래스의 정의 를 기반으로 만들어짐
    // Int 와 같인 원시 타입과 비슷한 타입들도 -> 메서드, 프로퍼티 제공
    // 1.5.toInt() -> 더블값을 int 로 변환 , 이런 것도 가능
    // 하위 타입개념으로 계층화 가능 ,
    // null 을 허용하지 않는 모든 코틀린 타입은 Any 라는 내장 타입이 직간접적 하위 타입임

    val n3: Any = 1 // Int 는 Any 의 하위 타입


    // 7. 정수 타입
    // Byte, Short, Int, Long
    // 코틀린은 수 리터럴에 _ 을 넣어서 가독성을 높임

    val n5 = 34_721_189
    val hundredLong = 100L
    // l , L 로 Long 표현

    val bin = 0b10101
    // 0b, 0x 진수 표현

    val zero = 0
    // 0표현이 아닌 이상 0이 앞에 올 수 없다.

    val neg = -10
    // -10 음수는 리터럴이 아님. 단항 음수 연산자를 리터럴에 적용한 것.

    val short_min = Short.MIN_VALUE
    val short_max = Short.MAX_VALUE
    // 정수 타입의 최대 최솟값


    // 8. 부동 소수점 수
    // float, double
    val pi = 3.14

    // 정수 부분이 비어있는 경우 정수 부분을 0으로 간주함
    // 소수 부분은 생략할 수 없음
    val quarter = .25
    val two = 2 // 정수 리터럴

    // 과학적 표기법 리터럴을 허용함
    // e, E 뒤에 10을 몇번 거듭제곱하는지
    val pi2 = 0.314E1

    // Double 이나 Float 의 6진 리터럴 지원하지 않음
    // 부동 소수점 디폴트로 리터럴은 Double 타입이다.
    // f,F 를 붙이면 Flouat 타입이 됨 -> 이 경우 소수점을 포함한 소수부분을 생략 가능

    //val pi: Double = 3.14f // error
    // Float 리터럴이 Double 타입으로 자동 변환 되지 않음

    // MIN_VALUE, MAX_VALUE
    // NaN -> 0/0 처럼 숫자가 아닌 값

    // 3. 산술 연산
    //floorDiv() -> "버림 나눗셈(floor division)" → 나눗셈 결과를 0이 아니라 ‘음수 쪽으로’ 버림"

    init {
        println(7.floorDiv(3))    // 2
        println((-7).floorDiv(3)) // -3  (중요!)
    }
    //mod() -> 정수 나머지 연산
    // Double > Float > Long > Int > Short > Byte
    // 산술 연산의 결과는 인자 중 더 큰 의미를 지니는 타입이 됨
    // Long -> Float 로 변환 되는 경우 정밀도 떨어짐

    // 4. 비트 연산
    // shi, shr , ushr , and ,or ,xor ,inv


    // 5. 문자 타입 Char
    // 16비트
    // 작은따옴표 '' 사이에 넣으면 됨
    // 이스케이프 제공
    // 자바에서는 char 연산이 암시적으로 정수로 변환되지만
    // 코틀린에서는 Char 연산은 (두문자 차이 제외) Char 로 돌려줌
//    자바는 char를 내부적으로 **정수(16비트 정수)**처럼 취급한다.
//    그래서 char 끼리 덧셈, 뺄셈을 하면 자동으로 int로 승격된다(implicit conversion).
//    Kotlin에서는 Char는 그냥 문자, 숫자처럼 자동 변환되지 않는다.
//    덧셈, 뺄셈 불가능.

    //6. 수 변환
    // val n = 100
    // val l: Long = n
    // 타입으로 변환하는 연산이 정의되어있는데 목적에 맞게 쉽게 정의되어있음
    // toByte(), toShort()

    val n6 = 100
    // val l: Long = n  error
    val l: Long = n.toLong()

    // 암시적인 박싱 (Int 값이 꼭 원시타입으로 표현된다는 보장이 없ㅇ므)
    // Kotlin의 Int가 항상 자바의 primitive int로 저장된다는 보장이 없다
    // = Kotlin의 Int는 JVM에서 상황에 따라 원시 타입(int) 또는 객체(Integer) 로 바뀐다.
    // JVM에서 동작할 때는 다음 두 경우가 있다.
    //
    //primitive int로 사용되는 경우
    //
    //지역 변수, 연산, 일반적인 함수 파라미터/리턴 값에서는
    //성능 최적화를 위해 JVM이 primitive int로 자동 변환(unboxed)한다.
    //
    //boxed Integer(객체)로 사용되는 경우도 있음
    //Kotlin은 필요하면 Int를 java.lang.Integer 객체로 박싱한다.
    //



    // 7. 불 타입과 논리 연산

    val hasErrors = false;

    init {

        val x = 1;
        val y = 2;

        println((x == 1) or (y == 1))

    }

    // 코틀린으 & , | 연산자 제공하지 않음
    // or , and ,xor 로 대체

    // 8. 비교와 동등성
    // 코틀린은 두 인자가 모두 같은 타입일 때만 == , != 허용
    // 박싱이 암시적으로 진행되기 때문에 , 혼란을 야기할 수 있다.

    // 모든 수 타입의 값은 서로 <, <= , > , >= 로 비교할 수 있다.
    // Char , Boolean 값도 비교 연산 가능 , (같은 타입)

    // 자바에서는 원시 타입(int, boolean, double 등)을 객체 타입(Integer, Boolean, Double)으로 자동 변환할 수 있습니다. 이를 박싱이라고 하고, 반대로 객체를 원시 타입으로 변환하는 것을 언박싱이라고 합니다.
    //
    // 박싱된 값과 언박싱된 값은 타입이 다르더라도 비교가 가능하지만, **참조 비교(==)와 값 비교(equals)**를 구분해야 합니다.
    //  boolean은 순서가 없고 두 값 true/false만 존재합니다.
    //  따라서 비교는 동등성(==)이나 Boolean.equals()만 가능합니다. 크기 비교(>, <)는 불가능합니다.
    // 자바 boolean 은 순서가 없기 때문에 동등성 비교만 적용할 수 있다.
    //  NaN 은 그 어떤 값일아도 같지 않고,  Double 에서 가장 큰 값으로 취급 (무한대 보다)
    // 사실 NaN은 정렬 시 특별 처리되지 않는 이상 숫자 비교에서 최댓값이나 최솟값으로 고려되지 않습니다.
    //


    // 3. 문자열
    // String 타입 -> 불변 객체

    val hello = "Hello World!"

    // 새줄문자 ,특수 문자가 들어가면 이스케이프 시퀀스를 사용

    val hello2 = "Hello \n World!"

    // ${} 의 중괄호 사이에 넣기만 하면, 올바른 코틀린 식 들을  문자열에 넣을 수 있음
    // 기호만 붙여도 되고, 이런 기능을 문자열 템플릿이라고 함

    val name = readLine()
    init {
        println("Hello, $name! \n Today is ${Date()}")
    }

    // 문자열 템플릿 안의 식은 어떤 값이 든 될 수 있는데,
    // toString() 메서드를 통해 문자열로 변환

    // 로우 문자열 , 이스케이프 시퀀스를 사용하지 않고도 문자열을 작성할 수 있음
    // 이러한 리터럴은 큰 따옴표 세개로 둘러쌓여 있고, 새줄 문자 포함 등등..

    val messages = """
        Hello $name
    """.trimIndent()

    // trimIndent() 는 여러줄에 공통된 최소 들여쓰기를 제거해주는 함수
    // 로우 문자열에 특수문자는 ${} d안에 적어주면 된다.

    // 2. 기본 문자열 연산

    // length -> 문자 수를 표현
    // lastIndex  -> 마지막 문자 인덱스 표현

    init {
        println("Hello".length)
        println("Hello".lastIndex)
    }

    // 인덱스를 각괄호 안에 넣어 개별 문자 접근 가능 s[0]
    // + 연산자를 통해 문자열 연결 가능

    val sum = 1
    val s = "The sum  is: " + sum

    // 문자열은 == , != 로 동등성을 비교할 수 있음.
    // 코틀린에서 참조 동등성은 ===, !== 사용

    // 문자열은 사전식 순서로 정렬된다.
    // <, > 등의 비교 연산자 사용 가능

    // 문자열은 toByte() toShort() 등의 변환 함수를 제공

    //4. 배열
    // Array<T>
    // T 는 원소의 타입

    val a = emptyArray<String>() // 원소 0개
    val b = arrayOf("hello world") // 두개
    val c = arrayOf(1,2,3) // 원소 3개

    // 각함수는 제네릭 하다. = 호출할 때 원소 타입을 지정해야함
    // 타입 추론이 어려운 경우에는 타입을 명시해야한다.

    // 인덱스로 원소를 만들어내는 방법

    val size  = readLine()!!.toInt()
    val squares = Array(size) { (it + 1) * (it + 2) }

    // 중괄호 안의 요소를 람다라고 부름
    // ㅇ ㅣㄴ덱스를 기반으로 값을 계산하는 식을 정의함
    // 인덱스를 표혀하는 변수로 자동 선언되는 -> it 을 사용

    // Array 는 모든 수를 박싱해버리기 때문에 코틀린은 더 효율적인 배열타입을 제공함
//    효율적인 배열 타입
//    코틀린은 원시 타입 전용 배열을 제공해서 박싱 없이 저장할 수 있습니다:
    // ByteArray , ShortArray 등등

    val operations = charArrayOf('+', '-', '*')
    val squares2 = IntArray(10) {(it + 1) * (it + 1)}

    // 자바와 달리 코틀린에느 new 연산자가 없다!! -> 호출하는 것 처럼 보임
    // 배열 우너소를 명시적으로초기화해야한다.

    // 2. 배열 사용하기

    // size 와 lastIndex 프로퍼티가 있다는 점

    val arr = arrayOf(1,2,3,4)
    init {
        arr.size
        arr.lastIndex
        arr[2]

        arr[1] = 2
        // 문자열과 달리 배열에서는 원소 변경 가능

        val copyArr = arr
        copyArr[0] = 1000
        println(copyArr)
        // 바뀐데이터가 공유된다 . (참조를 저장하기 때문에 배열을 대입해도 같은 집합을 공유함)

        // 원본과 같은 배열을 사용하려면 .copyOf()  사용
        val copyArr2 = arr.copyOf()

        val arr1: IntArray = intArrayOf(1, 2, 3)
        val arr2: IntArray = intArrayOf(4, 5, 6)
        // 다른 배열을 대입하려고 하면 오류
        // arr1 = arr2  // 오류: val이므로 재할당 불가

        // 배열 타입 변숭에 , 다른 배열을 대입할 수 없음. => val은 재할당 불가
        // 모든 다른 배열 타입과 , 서로 하위 타입 관계가 성립 되지 않는다고 간주.
        // String 은 Any 의 하위타입
        // 배열 생성 후 길이 변경은 안되지만, + 연산으로 원소를 추가한 새로운 배열은 가능


        // 참조 비교
        intArrayOf(1,2,3) == intArrayOf(1,2,3)
        // 배열 내용 비교는 contentsEquals() 함수
        intArrayOf(1,2,3).contentEquals(intArrayOf(1,2,3))
        //isEmpty 배열이 있는지
        //isNotEmpty 원소가 있는지
        //indexpf  인자와 일치하는 최초의 배열 아이템 반환


    }



}