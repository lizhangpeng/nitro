<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-首页</title>
	<link rel="stylesheet" type="text/css" href="/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/css/main.css">
	<script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/js/slide.js"></script>
</head>
<body>
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎来到天天生鲜!</div>
			<div class="fr">
					<#if user??>
						<div class="login_info fl">
					           欢迎您：<em>${user.user_naem}</em>
				        </div>
						<div class="user_link fl">
						<span>|</span>
						<a href="user_center_info.html">用户中心</a>
						<span>|</span>
						<a href="cart.html">我的购物车</a>
						<span>|</span>
						<a href="user_center_order.html">我的订单</a>
						</div>
				     <#else>
				       	   <div class="login_btn fl">
					       <a href="/login.html">登录</a>
					       <span>|</span>
					       <a href="/register.html">注册</a>
				          </div>
				       
				    </#if>
			

			</div>
		</div>		
	</div>

	<div class="search_bar clearfix">
		<a href="index.html" class="logo fl"><img src="/images/logo.png"></a>
		<div class="search_con fl">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>
		<div class="guest_cart fr">
			<a href="#" class="cart_name fl">我的购物车</a>
			<div class="goods_count fl" id="show_count">1</div>
		</div>
	</div>

	<div class="navbar_con">
		<div class="navbar">
			<h1 class="fl">全部商品分类</h1>
			<ul class="navlist fl">
				<li><a href="">首页</a></li>
				<li class="interval">|</li>
				<li><a href="">手机生鲜</a></li>
				<li class="interval">|</li>
				<li><a href="">抽奖</a></li>
			</ul>
		</div>
	</div>

	<div class="center_con clearfix">
		<ul class="subnav fl">
			<#if typeEntities??>
				<#list typeEntities as type>
                  <li><a href="#model01" class="fruit">${type.name}</a></li>
                </#list>
			
			</#if>

		</ul>
		<div class="slide fl">
			<ul class="slide_pics">
				<li><img src="/images/slide.jpg" alt="幻灯片"></li>
				<li><img src="/images/slide02.jpg" alt="幻灯片"></li>
				<li><img src="/images/slide03.jpg" alt="幻灯片"></li>
				<li><img src="/images/slide04.jpg" alt="幻灯片"></li>
			</ul>
			<div class="prev"></div>
			<div class="next"></div>
			<ul class="points"></ul>
		</div>
		<div class="adv fl">
			<a href="#"><img src="/images/adv01.jpg"></a>
			<a href="#"><img src="/images/adv02.jpg"></a>
		</div>
	</div>
	
	

<#list goodsEntities?keys as key>

<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model02">${key}</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">河虾</a>
				<a href="#">扇贝</a>				
			</div>
			<a href="#" class="goods_more fr">查看更多 ></a>
		</div>
		<#assign item = goodsEntities[key]>   
		<div class="goods_con clearfix">
		<div class="goods_banner fl"><img src="/images/banner02.jpg"></div>
		<#if item?size != 0>
			<ul class="goods_list fl">
    			<#list item as itemValue>
  						<li>
						<h4><a href="#"> ${itemValue.title}</a></h4>
						<a href="#"><img src=" ${itemValue.image}"></a>
						<div class="prize">¥  ${itemValue.price}</div>
					</li>	
     			</#list>
			</ul>
		</div>
        </#if>

   </div>

   
</#list>

	<div class="footer">
		<div class="foot_link">
			<a href="#">关于我们</a>
			<span>|</span>
			<a href="#">联系我们</a>
			<span>|</span>
			<a href="#">招聘人才</a>
			<span>|</span>
			<a href="#">友情链接</a>		
		</div>
		<p>CopyRight © 2016 北京天天生鲜信息技术有限公司 All Rights Reserved</p>
		<p>电话：010-****888    京ICP备*******8号</p>
	</div>
	<script type="text/javascript" src="js/slideshow.js"></script>
	<script type="text/javascript">
		BCSlideshow('focuspic');
		var oFruit = document.getElementById('fruit_more');
		var oShownum = document.getElementById('show_count');

		var hasorder = localStorage.getItem('order_finish');

		if(hasorder)
		{
			oShownum.innerHTML = '2';
		}

		oFruit.onclick = function(){
			window.location.href = 'list.html';
		}
	</script>
</body>
</html>