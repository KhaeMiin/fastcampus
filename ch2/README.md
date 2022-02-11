
# fastcampus-1
스프링의 정석: 남궁성 선생님과 함께

## :pushpin: AWS(_Amazon Web Services_)
- AWS란?
	- Amazion이  제공하는 Cloud Service
	- 관리가 쉽고 유연한 확장성(즉, 하드웨어(HW)의 추상화)이 장점,
- Amazion EC2
	- Instance(가상 컴퓨터라고 볼 수 있음)
- S3 (Simple Storage)
	- 확장성, 가용성(여러 서버에서 공유할 수 있다), 내구성(데이터가 깨질 경우 복구가 가능하다) 을 가진데이터 저장공간을 제공
- RDS
	- 관계형 DB (MySQL, Oracle 등)을 사용할 수 있는, 주기적으로 백업이 가능한

</br>

## :pushpin: HTTP 요청과 응답
``` java
//1.원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {

	//2.URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() { //인스턴스 메서드
	//private일 경우: 작동된다. private:같은 패키지 url로 메서드를 연결했다는건 접근제어자 상관없이 외부에서 호출가능하게(Reflection API)
	}
}
```
- 서버가 제공하는 리소스
	- 동적 리소스: 프로그램,스트리밍 등 내용이 고정되어 있지 않고, 실행마다 결과가 다른 리소스
	- 정적 리소스: 고정되어 있음(이미지,js,css,*html) 

<details>
<summary><b>1. 프로토콜이란?(Protocol) </b></summary><br>
<div markdown="1">
서로간의 통신을 위한 약속/규칙으로
주고 받을 데이터에 대한 형식을 정의한 것.<br>
즉, 어떤 형식으로 데이터를 주고 받을지 규칙을 정하는 것이다.
</div>
</details>

<details>
<summary><b>2. HTTP 란? </b></summary><br>
<div markdown="1">
Hyper Text(html) Teansfer(전송) Protocol

1. 텍스트 기반의 프로토콜(텍스트를 보내기 위한): 단순하고 읽기 쉽다.
2. 상태를 유지하지 않는다 = 상태가 없다. 즉, 클라이언트 정보를 저장하지 않습니다. (요청을 2번을 보내도 같은 클라이언트인지 구별할 수 없다.)
-> 보완하기 위해 쿠키,세션을 이용(나중에 다시 설명)
3. 확장이 가능하다.(커스텀 헤더가능)

</div>
</details>

##  :pushpin: 클라이언트와 서버
<details>
<summary><b>1. 클라이언트와 서버 </b></summary>
<div markdown="1">

- 클라이언트(Client): 서비스를 요청하는 에플리케이션(or컴퓨터)
- 서버(Server): 서비스(Service)를 제공하는 에플리케이션(or컴퓨터)
	- Tomcat이 있다.
</div>
</details>

<details>
<summary><b>2. 서버의 종류 </b></summary>
<div markdown="1">

어떤 서비스를 제공할 것인가?
- WebService: 브라우저로 할 수 있는 모든 것
- EmailService
- FileService

포트(port)번호로 구분이 가능하다.
</div>
</details>

<details>
<summary><b>4. 웹 애플리케이션 서버(WAS)란? </b></summary>
<div markdown="1">

####  웹 애플리케이션 서버(WAS): 웹 애플리케이션을 서비스하는 서버(Tomcat)
- Web Application Service? : 에플리케이션(프로그램)을 클라이언트가 사용할 수 있도록
- EmailService
- FileService

포트(port)번호로 구분이 가능하다.
</div>
</details>


## :pushpin: 쿠키(Cookie)
> 수업코드<br>
> [controller](https://github.com/KhaeMiin/fastcampus/blob/master/ch2/src/main/java/com/fastcampus/ch2/LoginController.java)<br>
> [jsp](https://github.com/KhaeMiin/fastcampus/blob/master/ch2/src/main/webapp/WEB-INF/views/loginForm.jsp#L60)<br>
### 1. 쿠키란?
- 이름과 값의 쌍으로 구성된 작은 정보다.
name = value
- 기본적으로 아스키 문자만 저장이 가능하다.
(한글은 URL인코딩을 해줘야한다.)

- 서버에서 생성 후 전공, 브라우저에 저장. 유효기간이 지나면 자동 삭제된다.
- 서버에 요청시 도메인과 path가 일치(하위경로 포함)하는 경우에만 자동으로 전송

### 2.작동 과정
- 클라이언트가 서버에 요청한다.
- 서버가 코드를 수행한 후 쿠키가 만들어지고 응답에 담아서 보낸다.
set-Cookie: name=value
- 응답이 클라이언트한테 전달됨(쿠키도 함께)
- 서버가 보내준 쿠키가 브라우저에 저장이 됨
- 클라이언트가 서버에 요청하게되면 저장된 쿠키도 요청헤더에 쿠키가 따라간다.
<br>
쿠키: 클라이언트 식별 기술(구별)

### 3.쿠키의 생성
```
//서버에서 실행되는 코드
Cookie cookie = new Cookie("id","asdf"); //쿠키 생성("name","value")
cookie.setMaxAge(60*60*24); //유효기간 설정(초)
reponse.addCookie(cookie); //응답에 쿠키 추가(서버 헤더에 넣어준다)
```
### 3.쿠키의 삭제와 변경
```
//서버에서 실행되는 코드
Cookie cookie = new Cookie("id",""); //변경할 쿠키와 같은 이름 쿠키생성(value안넣어줘도된다)
cookie.setMaxAge(0); //유효기간을 0으로 설정(삭제)
reponse.addCookie(cookie); //응답에 변경된 쿠키 추가(서버 헤더에 넣어준다)
```

### 4.쿠키의 변경
```
//서버에서 실행되는 코드
Cookie cookie = new Cookie("id",""); //변경할 쿠키와 같은 이름 쿠키 생성
cookie.setValue(URLEncoder.encode("변경name")); //값의 변경
cookie.setDomain("www.fastcampus.co.kr");//도메인변경
cookie.setPath("/ch2"); //경로변경
cookie.setMaxAge(60*60*24*7); //유효기간 설정(초)
reponse.addCookie(cookie); //응답에 쿠키 추가(서버 헤더에 넣어준다)
```
### 5.쿠키 읽어 오기

```
//쿠키가 여러개일 수 있으니 배열사용
Cookie[] cookies = request.getCookie(); //쿠키 읽기

for(Cookie cookie : cookie) {
String name = cookie.getName();
String value = cookie.getValue();

System.out.printf("[cookie]name=%s, value=%s%n", name, value);
}
```
