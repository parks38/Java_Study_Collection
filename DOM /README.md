## Javascript vs. JQuery 
--------------------------
|Javacript | JQuery |
|-----------|----------|
| document.addEventListener('DOMContentLoaded', function() {}); | $(function(){}); |
| document.ready(function() {}); | $(function(){}); |
--------------------------

### ('선택자').css('attribute', 'value); 
: css 스타일 변경
```
$(HTML 요소).메서드('매개변수1', '매개변수2')
```

### event 
: event 종류 - mouseover 마우스가 올라왔을때 
  bind('click' ... -> .on  off
````
$('selector').on('event type' to do);
// to do = function(){}

$('selector').mouseover(function() {
    $(this).css('background-color', 'green');
    // something event 
})
.mouseout(function(){
    // event something
});
````
- keydown
- keyup
- focus
- blur
- change
-resize
-scroll

### animation
````
$(function() {
    $('selector').click(function() {
        $(this).animate({attribute:value}, time, eazing, others);
    });
});
````

### 서랍 메뉴 
```
$(function() {
    var $aside = $('aside'),
        $button = $aside.find('button'); // 큰거 찾고 find 이용하는게 ('aside button') 보다 빠름 
        $duration = 300;
    // 버튼 클릭 aside 나오도록 
    // js -> selector.classList.add = 'open'
    $button.click(function() {
        $aside.toggleClass('open');
        if($aside.hasClass('open')) {
            $asdie.stop().animate({left:'-70px'}, $duration, 'easeOutBack');
            $button.find('img'.attr('src', 'img/btn_close.png'));
        } else {
            $asdie.stop().animate({left:'-250px'}, $duration, 'easeInBack');
            //속성 변경하기, 값을 반환하기 
            $button.find('img'.attr('src', 'img/btn_open.png')); 
        }
    }); 
});
```
- selector.addClass('A');  || selector.removeClass('B')
- A.toggleClass('b');
- A.hasClass('b') 조건문 = true / false
- var c = A.attr('b') = a 라는 요소의 b 라는 속성명의 값 c 에 저장 
- A.attr('b', 'c') = a 요소의 b라는 속성의 값을 c 로 변경 

### AJAX (asynchronous Javascript and XML)
````
$(function(){
    $.ajax({
        url: /url.jsp,
        type: 'POST',
        data: 요청변수 설정,
        dataType: jsontype,
        crossDomain : true
    }).success:function(jsonStr) { //주소 검색 결과 json 데이터 

    }
})
````
