<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<h4>会员注册</h4>

<hr style="width:300px;height:1px;">

<table class="my_table table table-bordered">
	<tr>
		<td>分享人编号</td>
		<td>
			<input type="text" placeholder="分享人编号" id="shareSerial" class="form-control my_loginInput">
		</td>
	</tr>
	<tr>
		<td>账号</td>
		<td>
			<input type="text" placeholder="请输入账号" id="username" class="form-control my_loginInput">
		</td>
	</tr>
	<tr>
		<td>密码</td>
		<td>
			<input type="password" placeholder="请输入密码" id="password" class="form-control my_loginInput">
		</td>
	</tr>
	<tr>
		<td>手机</td>
		<td>
			<input type="text" placeholder="请输入手机号" id="phone" class="form-control my_loginInput">
		</td>
	</tr>
	<tr>
		<td>真实姓名</td>
		<td>
			<input type="text" placeholder="真实姓名" id="trueName" class="form-control my_loginInput">
		</td>
	</tr>
	<tr>
		<td>收货地址</td>
		<td>
			<input type="text" placeholder="收货地址" id="address" class="form-control my_loginInput">
		</td>
	</tr>
</table>

<button class="btn btn-info btn-block" onclick="consumer.preRegister()">注册</button>
