
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


