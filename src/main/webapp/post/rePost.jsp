<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<body style="margin: 20px; font-family: 'Arial', sans-serif; background-color: #f5f5f5; color: #000;">

<div style="max-width: 600px; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">

	<h3 style="color: #7D4214; text-align: center;">상품 정보 입력</h3>

	<form action="reFile.upload" method="post" enctype="multipart/form-data" style="display: flex; flex-direction: column;">
		<input type="hidden" name="pno" value="${vo.pno}"  >
		<label style="margin-top: 10px; font-weight: bold;">사진 업로드</label>
		<input type="file" name="file" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">

		<label style="margin-top: 10px; font-weight: bold;">제목</label>
		<input type="text" name="title" placeholder="제목" value="${vo.title}" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">

		<label style="margin-top: 10px; font-weight: bold;">주 키워드</label>
		<select name="categori" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px; height: 40px;">
			<option>패션/의류</option>
			<option>리빙/가전</option>
			<option>식품</option>
			<option>문구/생활용품</option>
			<option>PC/핸드폰</option>
			<option>기타</option>
		</select>

		<label style="margin-top: 10px; font-weight: bold;">보조 키워드</label>
		<input type="text" name="key1" placeholder="보조 키워드" value = "${key1 }" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">
		<input type="text" name="key2" placeholder="보조 키워드" value = "${key2 }" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">
		<input type="text" name="key3" placeholder="보조 키워드" value = "${key3 }" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">

		<label style="margin-top: 10px; font-weight: bold;">거래방식</label>
		<div style="display: flex; margin-top: 10px;">
			<input type="radio" name="sellType" value="판매하기" checked style="margin-right: 5px;">
			<label for="sellType1">판매</label>
		</div>
		<div style="display: flex; margin-top: 10px;">
			<input type="radio" name="sellType" value="나눔하기" style="margin-right: 5px;">
			<label for="sellType2">나눔</label>
		</div>

		<label style="margin-top: 10px; font-weight: bold;">₩ 가격을 입력해 주세요.</label>
		<input type="text" name="price" placeholder="₩ 가격을 입력해 주세요." value = "${vo.price }" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">

		<label style="margin-top: 10px; font-weight: bold;">자세한 설명</label>
		<textarea rows="5" cols="50" name="content" placeholder="판매하실 상품의 정보를 입력해주세요. 부적절한 상품은 판매하지 못하실 수 있어요." style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px; resize: vertical;">${vo.content }</textarea>

		<label style="margin-top: 10px; font-weight: bold;">거래 희망장소</label>
		<input type="text" name="address" placeholder="희망 장소를 입력해주세요." value = "${vo.address }" style="width: 100%; padding: 10px; margin-top: 5px; margin-bottom: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 5px;">

		<input type="submit" name="sellbutton" value="판매하기" style="background-color: #7D4214; color: #fff; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; transition: background-color 0.3s; margin-top: 10px;">

	</form>
</div>
</body>
</html>
