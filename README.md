<h2> WebServlet-JSP </h2>

<h3> 해당 저장소는 WebServlet과 JSP만을 이용하여 간단한 게시판을 만들어보는 저장소입니다.</h3>

Servlet을 기본 베이스로 스프링의 진입 전에 JSP, MVC 패턴 -> JSP, FrontController, Adapter 패턴 -> SQL Mapper, MVC 패턴
단계로 점차 발전시킬 예정입니다.

(해당 버전은 MVC 패턴에 대한 이해가 부족한 상황에서 학습을 위한 원격 저장소이며, VO 및 DTO에 대한 정의가 부족한 상태입니다.)


<h4 style="color: #3e8e41">Login</h4>

<p style="color: yellow">-[o] 회원 가입시 회원 정보를 데이터베이스에 저장</p>

<p style="color: yellow">-[o] 로그인 시 데이터베이스에 저장된 정보와 다를 경우 그에 맞는 오류 메시지 및 행동 추천(회원 가입 추천)</p>


<h4 style="color: #3e8e41">Post</h4>

<p style="color: yellow">-[o] 게시글 등록시 정보를 데이터베이스에 저장</p>

<p style="color: yellow">-[o] 게시글에 제목과, 내용, 작성날짜가 표기됨.</p>

<p style="color: yellow">-[o] 게시글 메인화면에서는 데이터베이스에 등록된 모든 게시글 불러옴. 게시글 최대 5개 까지 보임.</p>

<p style="color: yellow">-[o] 게시글 클릭 시 상세화면</p>

<p style="color: yellow">-[o] 게시글 상세화면 페이지에서 세션값으로 작성자와 로그인 한 사람을 비교-> 같은 사람일 경우 delete,update 기능 제공</p>

<p style="color: yellow">-[o] delete 기능과 update기능 제공, delete시 데이터베이에서 삭제되는 것이 아니라 Available 속성 값이 변함</p>
