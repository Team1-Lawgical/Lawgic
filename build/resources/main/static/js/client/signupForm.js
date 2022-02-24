
$(document)
    .ready(
        function() {
            var checkResultId = "";
            var isCertification = false;
            var key = "";
            var fullEmail = "";
            var domainVal = "";
            $("#regForm").submit(
                function() {
                    if (checkResultId == "") {
                        alert("모든 항목을 작성하세요.");
                        return false;
                    }
                    if ($('#name').val() == null
                        || $('#name').val() == "") {
                        alert("이름을 입력해주세요.");
                        return false;
                    }
                    if ($('#password1').val() == null
                        || $('#password1').val() == "") {
                        alert("비밀번호를 입력해주세요.");
                        return false;
                    }
                    if ($('#password2').val() == null
                        || $('#password2').val() == "") {
                        alert("비밀번호를 한 번 더 입력해주세요.");
                        return false;
                    }
                    if ($('#email').val() == null
                        || $('#email').val() == "") {
                        alert("이메일을 입력해주세요.");
                        return false;
                    }
                    if ($('#address').val() == null
                        || $('#address').val() == "") {
                        alert("주소를 입력해주세요.");
                        return false;
                    }
                    if ($('#carType').val() == null
                        || $('#carType').val() == "") {
                        alert("차급을 선택해주세요.");
                        return false;
                    }
                    if ($('#birthday').val() == null
                        || $('#birthday').val() == "") {
                        alert("생년월일을 입력해주세요.");
                        return false;
                    }
                    //
                    // if (isCertification == false) {
                    //     alert("메일 인증이 완료되지 않았습니다.");
                    //     return false;
                    // }
                    domainVal = $(".domain").val();
                    // $("#email").val($("#email").val() + "@" + $(".domain").val());
                    // $("#email").val($("#email").val() + "@" + $(".domain").val());
                    console.log(domainVal);
                });
            $("#regForm :input[name=email]")
                .keyup(
                    function() {
                        var email = $(this).val().trim();
                        // fullEmail = email + "@" + $(".domain").val();
                        // if (id.length<4 || id.length>10) {
                        //     $("#idCheckView")
                        //         .html(
                        //             "이메일 글자수 체크")
                        //         .css("color", "red");
                        //     checkResultId = "";
                        //     return;
                        // }
                        // spring security 적용시 ajax post 방식은 아래와 같이 beforeSend property에서 csrf 값을 셋팅해야 함

                        $
                            .ajax({
                                type : "post",
                                url : "/client/checkAjax",
                                data : "id=" + email,
                                success : function(data) {
                                    if (data == "fail") {
                                        $(
                                            "#idCheckView")
                                            .html(
                                                email
                                                + " 사용불가!"
                                                // 이메일 전체 출력하기위해
                                                + fullEmail
                                            )

                                            .css(
                                                "color",
                                                "red");
                                        checkResultId = "";
                                    } else {
                                        $(
                                            "#idCheckView")
                                            .html(
                                                email
                                                + " 사용가능!"
                                                // 이메일 전체 출력하기위해
                                                + fullEmail
                                            )
                                            .css(
                                                "color",
                                                "blue");
                                        checkResultId = email;
                                    }
                                }//callback
                            });//ajax
                    });//keyup

            // $("#sendMail")
            //     .click(
            //         function() {
            //             var mail = $("#email").val(); //사용자의 이메일 입력값
            //             if (mail == "") {
            //                 alert("메일이 입력되지 않았습니다.");
            //             } else {
            //                 mail = mail + "@"
            //                     + $(".domain").val();
            //                 $
            //                     .ajax({
            //                         type : 'post',
            //                         url : '/member/CheckMail',
            //                         data : {
            //                             mail : mail
            //                         },
            //                         async : "false",
            //                         dataType : 'json',
            //                         success : function(
            //                             data) {
            //                             key = data.key;
            //                         }
            //                     });
            //                 alert("인증번호가 전송되었습니다. 이메일을 확인해주세요.");
            //                 $(".compare").css("display",
            //                     "inline");
            //                 $(".compare-text").css(
            //                     "display", "inline");
            //             }
            //         });
            // $(".compare").on(
            //     "propertychange change keyup paste input",
            //     function() {
            //         if ($(".compare").val() == key) {
            //             $(".compare-text").text("인증 성공").css(
            //                 "color", "blue");
            //             isCertification = true;
            //         } else {
            //             $(".compare-text").text("인증번호 불일치")
            //                 .css("color", "red");
            //             isCertification = false;
            //         }
            //     });
        });//ready

$(function() {
    $('#password2').blur(function() {
        if ($('#password1').val() != $('#password2').val()) {
            if ($('#password2').val() != '') {
                alert("비밀번호가 일치하지 않습니다.");
                $('#password2').val('');
                $('#password2').focus();
            }
        }
    })
});