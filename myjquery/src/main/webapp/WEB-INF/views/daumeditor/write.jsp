<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<link rel="stylesheet" href="/resources/daumeditor/css/editor.css" type="text/css" charset="utf-8" />
<script src="/resources/daumeditor/js/editor_loader.js?environment=development"	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>

<jsp:include page="/WEB-INF/views/daumeditor/editor_template.jsp"></jsp:include>


<html>
<head>
<title>Home</title>

<script type="text/javascript">

	function setConfig() {
		var config = {
			txHost : '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) http://xxx.xxx.com */
			txPath : '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) /xxx/xxx/ */
			txService : 'sample', /* 수정필요없음. */
			txProject : 'sample', /* 수정필요없음. 프로젝트가 여러개일 경우만 수정한다. */
			initializedId : "", /* 대부분의 경우에 빈문자열 */
			wrapper : "tx_trex_container", /* 에디터를 둘러싸고 있는 레이어 이름(에디터 컨테이너) */
			form : 'tx_editor_form' + "", /* 등록하기 위한 Form 이름 */
			txIconPath : "/resources/daumeditor/images/icon/editor/", /*에디터에 사용되는 이미지 디렉터리, 필요에 따라 수정한다. */
			txDecoPath : "/resources/daumeditor/images/deco/contents/", /*본문에 사용되는 이미지 디렉터리, 서비스에서 사용할 때는 완성된 컨텐츠로 배포되기 위해 절대경로로 수정한다. */
			canvas : {
				styles : {
					color : "#123456", /* 기본 글자색 */
					fontFamily : "굴림", /* 기본 글자체 */
					fontSize : "10pt", /* 기본 글자크기 */
					backgroundColor : "#fff", /*기본 배경색 */
					lineHeight : "1.5", /*기본 줄간격 */
					padding : "8px" /* 위지윅 영역의 여백 */
				},
				showGuideArea : false
			},
			events : {
				preventUnload : false
			},
			sidebar : {
				attachbox : {
					show : true,
					confirmForDeleteAll : true
				}
			},
			size : {
				contentWidth : 700
			/* 지정된 본문영역의 넓이가 있을 경우에 설정 */}
		};
		EditorJSLoader.ready(function(Editor) {
			editor = new Editor(config);
		});
	}
	

	$(function() {
		console.log( " path : " + "${pageContext.request.contextPath}" );
		setConfig();
		/* $.ajax({
			type : "POST",
			// url : "${pageContext.request.contextPath}/daumeditor/editor_template.html",
			// url : "/daumeditor/editor_template.html",
			url : "editor_template",
			success : function(data) {
				$("#editorTd").html(data);
				setConfig();
			},
			error : function(request, status, error) {
				//alert("에러");
			}
		}); */
		
		//form submit 버튼 클릭
	    $("#save").click(function(){
			//다음에디터가 포함된 form submit
	    	/* oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit(); */
			
			var val = oEditors.getById["editorTd"].exec("UPDATE_CONTENTS_FIELD", []);
			this.contents = $('#editorTd').val();
			alert(this.contents);
	    });
	})
	
	
 
	//Editor.save() 호출 한 다음에 validation 검증을 위한 함수
	//validation 체크해줄 입력폼들을 이 함수에 추가 지정해줍니다.
	function validForm(editor) {
	    var validator = new Trex.Validator();
	    var content = editor.getContent();
	    if (!validator.exists(content)) {
	        alert('내용을 입력하세요');
	        return false;
	    }
	    return true;
	}
	 
	//validForm 함수까지 true값을 받으면 이어서 form submit을 시켜주는  setForm함수
	function setForm(editor) {
	    var content = editor.getContent();
	    $("#content").val(content)
	    return true;
	}
</script>

</head>
<body>
	<form name="tx_editor_form" id="tx_editor_form" action="/insert.jsp"
		method="post" accept-charset="utf-8">
		<table width="100%">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td id="editorTd"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="save" value="저장" /> <input
					type="button" value="취소" /></td>
			</tr>
			
			
		</table>
	</form>


</body>
</html>
