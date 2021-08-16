<front-end>

    function signup()

    {

    	var member = {

    		"email": "test@naver.com",

    		"password": "1234"

    	};

    	

    	$.ajax({

    		url : '/account/signup',

    		dataType : 'json',

    		type : 'POST',

    		data : JSON.stringify(member), //그냥 member 사용하면 error 발생!

    		contentType : 'application/json; charset=UTF-8',

    		success : function(result) {

//TODO

    			console.log(result);

    		}

    	});

    }



<back-end>

	@RequestMapping(value = "/signup", method = RequestMethod.POST)

	public MemberResultDto signup(@RequestBody Member member)  

	{                         

		systemLog.info("try to sign up..");

//TODO 

		return memberResultDto;

	}


@RequestBody는 HTTP요청의 body 내용을 자바 객체로 매핑 하는 역할을 합니다.