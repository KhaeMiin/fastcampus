
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
	- 관계형 DB (MySQL, Oracle 등)을 사용할 수 있는, 주기적으로 백업이 가능한.
	- 클라우드에서 관계형 데이터베이스를 더욱 쉽게 설정, 운영 및 확장할 수 있도록 지원하는 웹 서비스
	- 이 서비스는 산업 표준 관계형 데이터베이스를 위한 경제적이고 크기 조절이 가능한 용량을 제공하고 **공통 데이터베이스 관리 작업을 관리**


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


## :pushpin: 세션(Session)
### 세션(Sesscion)이란?
**서로 관련된 요청(응답포함)들을 하나로 묶은 것** → 쿠키를 이용
브라우저마다 개별저장도(Session 객체)를 서버에서 제공 → 서버에 저장

### 1. Controller에서 세션 저장소를 사용하기
```
HttpSession session = request.getSession();
session.setAttribute("key","value"); //저장소에 key라는 이름으로 value를 넣는다.
session .getAttribute("key"); //저장소에 key로 저장된 value를 가져온다.
```


### 2. 세션의 종료방법
1. 수동 종료
```
HttpSession session = request.getSession();
session.invalidate(); //방법1. 세션을 즉시 종료
session.setMaxInactiveInterval(30*60) //방법2. 예약 종료(30분 후)
```
2. 자동종료 - web.xml
```
<session-config>
	<session-timeout>30</session-timeout> //분단위
</session-config>
```
### 3.세션과 쿠키

|쿠키|서버|
|------|------|
|브라우저에 저장|서버에 저장|
|서버 부담이 없다.|서버에 부담이 있다.|
|보안에 불리|보안에 유리|
|서버 다중화에 유리|서버 다중화에 불리|


##  :pushpin: 예외 처리
- 예외 처리를 위한 메서드를 작성하고 @ExceptionHandler를 붙인다.
- @ControllerAdvice로 전역(모든 컨트롤러) 예외 처리 클래스 작성 가능(패키지 지정 가능: 아무것도 안적으면 모든 패키지)
	**예외 처리 메서드가 중복된 경우, 컨트롤러 내의 예외 처리 메서드가 우선**
- @ResponseStatus 
	응답 메세지의 상태 코드를 변경할 때 사용

	```
		@ResponseStatus(HttpStatus.Method_Not_ALLOWED)//405 Method Not Allowd
		@ExceptionHandler(NullPointException.class)
		public String catcher(Exception ex, Model m) {
			m.addAttribute("ex", ex);
			return "error";
		}
	```

- web.xml에 <error-page>로 상태 코드별 뷰 지정 가능 [코드참조](https://github.com/KhaeMiin/fastcampus/blob/master/ch2/src/main/webapp/WEB-INF/web.xml#L51)
	```
	//예시
		<error-page>
			<error-code>400</error-code>
			<location>/error400.jsp</location>
		</error-page>
	```
- 에외 종류별 뷰 맵핑에 사용. servlet-context.xml에 등록 [코드참조](https://github.com/KhaeMiin/fastcampus/blob/master/ch2/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml#L33)
	```
	<!--view-controller path="/register/add" view-name="registerForm"/-->	
	<context:component-scan base-package="com.fastcampus.ch2" />
	<beans:bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
		<beans:property name="defaultErrorView" value="error"/>
    		<beans:property name="exceptionMappings">
      			<beans:props>
        			<beans:prop key="com.fastcampus.ch2.MyException">error400</beans:prop>
      			</beans:props>
    		</beans:property>
		<beans:property name="statusCodes">
			<beans:props>
        			<beans:prop key="error400">400</beans:prop>
			</beans:props>
		</beans:property>
  	</beans:bean>
	```
- 정리: 스프링에서의 예외 처리
	- 컨트롤러 메서드 내에서 try-catch로 처리
	- 컨트롤러에 @ExceptionHandler가 붙은 메서드로 처리
	- @ControllerAdvice클래스의 @ExceptionHandler메서드가 처리
	- 예외 종류별로 뷰 지정 - SimpleMappingExceptionResolver
	- 응답 상태 코드별로 뷰 지정 - <error-page>
##  :pushpin: 데이터의 변환과 검증
### 데이터의 변환
1. WebDataBinder
	1. 요청 받은 데이터(parametaMap에 저장된)에 대한 타입변환 > 결과를 BindingResult에 저장(에러 발생시 에러와 함께)
		1. 커스텀propertyEditor
		2. Conversion Service
		3. defult PropertyEditor
		(1. ~ 3. 우선순위)
	2. 데이터 검증 > 에러 발생시 BindingResult(interface)에 저장, 문제 없을 경우 해당 객체에 결과값이 담긴다.
	3. BindingResult는 Controller로 넘겨줘서 Controller는 적절히 판단해서 처리
	[코드참조](https://github.com/KhaeMiin/fastcampus/blob/master/ch2/src/main/java/com/fastcampus/ch2/RegisterController.java#L37)
2. Controller에 변환기능 추가하기
[코드참조](https://github.com/KhaeMiin/fastcampus/blob/master/ch2/src/main/java/com/fastcampus/ch2/RegisterController.java#L20)

	```
		@InitBinder//현재 Controller내에서만 적용이 된다.
		public void toDate(WebDataBinder binder) {
		
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));//false: 빈 값을 허용할 것인지
			binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		}
	```
	
3. PropertyEditor 
	- 양방향 타입 변환(String -> 타입, 타입 -> String)
		특정 타입이나 이름의 필드에 적용 가능
		- 디폴트 PropertyEditor: 스프링이 기본적으로 제공
		- 커스텀 PropertyEditor: 사용자가 직접 구현. PropertyEditorSupport를 상속하면 편리
	- 모든 컨트롤러 내에서의 변환 - WebBinginglnitializer를 구현후 등록
	- 특정 컨트롤러 내에서의 변환 - 컨트롤러에 @InitBinder가 붙은 메서드를 작성(2. Controller에 변환기능 추가하기: 참조코드 확인)

4. Converter와 ConbersionService
	- Converter - 단방향 타입 변환(타입A -> 타입B)
						PropertyEditor(양방향)의 단점을 개선(stateful -> stateless(Converter))
						(Property: iv 인스턴스 변수 > 싱글톤 사용불가: 객체를 계속하여 생성함)

5. Formatter 
	- 양방향 타입 변환(String → 타입, 타입 → String)
	바인딩할 필드에 적용 - @NumberFormat(숫자타입 변환 시 사용), @DateTimeFormat(날짜타입 변환시 사용)


### 데이터의 검증
6. Validator란?
	- 객체를 검증하기 위한 인터페이스. 객체 검증기(validator)구현에 사용
	```
	public interface Validator {
		//매개변수로 들어온 이 클래스가 이 검증기로 검증가능한 객체인지 알려주는 메서드
		boolean supports(Class<?> clazz);
		//객체를 검증하는 메서드 - target: 검증할 객체, errors: 검증시 발생한 에러저장소
		void validate(Object target, Errors errors);
	}
	```
7. Validator를 이용한 검증 - 수동
8. Validator를 이용한 검증 - 자동
9. 글로벌 Validator
	하나의 Validator로 여러 객체를 검증할 때, 글로벌 Validator로 등록
	- 글로벌 Validator로 등록하는 방법 
	```
	//servlet-context.xml
	<annotation-driven validator="globalValidator"/>
	<beans:bean id="globalValidator" class="com.git.ch2.GlobalValidator"/>
	//beans:bean: 빈등록
	```
	- 글로벌 Validator와 로컬 Validator를 동시에 적용하는 방법
	```
	//Controller
	@InitBinder
	public void toDate(WebDataBinder binder) {
	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	//binder.setValidator(new UserValidator()); //validator를 WebDataBinder에 등록
	binder.addValidators(new UserValidator()); //validator를 WebDataBinder에 등록      (UserValidator: 로컬Validator등록 - 컨트롤 내에서만 사용가능)
	```
	
10. MessageSource
	- 다양한 리소스에서 메시지를 읽기 위한 인터페이스
	- 프로퍼티 파일을 메시지 소스로 하는 ResourceBundleMessageSource라는 클래스를 빈으로 등록(servlet-context.xml)
11. 검증 메시지의 출력
	- 스프링이 제공하는 커스텀 태그 라이브러리 사용
	- ```<form>```대신 ```<form:from>```사용
	- ```<form:errors>```로 에러를 출력, path에 에러 발생 필드를 지정 (*은 모든 필드 에러)

