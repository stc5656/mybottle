<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
<section>
	<h1>회원 로그인</h1>
	<form method="post">
		<table>
			<tr>
				<td>
					<label>아이디 : </label> 
					<input name="username" />
				</td>
			</tr>
			<tr>
				<td>
					<label>비밀번호 : </label> 
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="로그인" value="로그인" />
					
				</td>
			</tr>
		</table>
	</form>
</section>
</main>
