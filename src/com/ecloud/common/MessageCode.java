package com.ecloud.common;

public class MessageCode {

	
	/**
	 * @author he
	 *返回状态代码注释
	 *成功 200
	 *失败300
	 *失败细分以3开头
	 */
	public final static int STATUS_SUCESS = 200;
	public final static int STATUS_FAIL = 300;
	/**
	 * 登录用户不存在
	 */
	public final static String ERROR_USERNAME="用户名不存在";
	/**
	 * 用户名已存在
	 */
	public final static String ERROR_HAVESAMEUSER="用户名已存在";
	
	/**
     * 该邮箱已注册
     */
    public final static String ERROR_HAVESAMEEMAIL="该邮箱已注册";
    
    /**
     * 该号码已注册
     */
    public final static String ERROR_HAVESAMEPHONENUMBER="该手机号已注册";
    
    /**
     * 账户未激活
     */
    public final static String ERROR_USERNOTACTIVETE="账户未激活,请到邮箱中激活账号！";
	/**
	 * 用户名不能包含中文字符
	 */
	public final static String ERROR_HAVECHINESE="用户名不能包含中文字符";
	
	/**
	 * 用户名不能为空
	 */
	public final static String ERROR_HAVEISNULL="用户名不能为空";
	/**
	 * 登录密码错误
	 */
	public final static String ERROR_PASSWORD="密码错误";
	/**
	 * 旧密码错误
	 */
	public final static String ERROR_PASSWORD_OLD="旧密码错误";
	
	/**
	 * 密码为空
	 */
	public final static String ERROR_PASSWORD_NULL="密码不能为空";
	/**
	 * 账户被禁用
	 */
	public final static String DISABLED_USER="账户被禁用";
	/**
	 * 兩次密码不一致（修改密码）
	 */
	public final static String PASSWORDS_NOTSAME="兩次密码不一致";
	/**
	 * 密码修改成功
	 */
	public final static String SUCESS_UPDATE_PASSWORD="密码修改成功";
	/**
	 * 密码修改失败
	 */
	public final static String ERROR_UPDATE_PASSWORD="密码修改失败";
	/**
	 * 新增成功
	 */
	public final static String SUCESS_ADD="新增成功";
	/**
	 * 新增失败
	 */
	public final static String ERROR_ADD="新增失败";
	/**
	 * 编辑成功
	 */
	public final static String SUCESS_UPDATE="编辑成功";
	/**
	 * 编辑失败
	 */
	public final static String ERROR_UPDATE="编辑失败";
	/**
	 * 删除成功
	 */
	public final static String SUCESS_DEL="删除成功";
	
	/**
     * 处理成功
     */
    public final static String SUCESS_DEAL="处理成功";
    
	/**
	 * 删除失败
	 */
	public final static String ERROR_DEL="删除失败";
	/**
	 * 代理商名字重复
	 */
	public final static String SAME_AGENTNAME="代理商名名称重复";
	/**
	 * 代理商有代理的酒店
	 */
	public final static String HAVE_HOTEL="代理商有代理的酒店,不能删除";
	
	/**
     * 代理商有代理的商家
     */
    public final static String HAVE_BUSINESS="代理商有代理的商家,不能删除";
	/**
	 * 酒店转移成功
	 */
	public final static String SUCESS_CHANGEHOTEL="酒店转移成功";
	
	/**
     * 转移酒店和商家成功
     */
    public final static String SUCESS_CHANGEHOTEL_BUSINESS="转移酒店和商家成功";
	
	/**
     * 请选择需要转移的酒店或商家
     */
    public final static String ERROR_CHANGE="请选择需要转移的酒店、商家、旅行社";
    
	/**
	 * 酒店转移失败
	 */
	public final static String ERROR_CHANGEHOTEL="酒店转移失败";
	
	/**
     * 商家转移失败
     */
    public final static String ERROR_CHANGEBUSINESS="商家转移失败";
    
    /**
     * 商家转移成功
     */
    public final static String SUCCESS_CHANGEBUSINESS="商家转移成功";
    
    /**
     * 旅行社转移成功
     */
    public final static String SUCCESS_CHANGETRAVEL="旅行社转移成功";
    
	/**
	 * 转移的酒店不能为空
	 */
	public final static String CHANGEHOTEL_CANNOTNULL="转移的酒店不能为空";
	/**
	 * 转移的代理商对象不能为空
	 */
	public final static String AGENET_CANNOTNULL="转移的代理商对象不能为空";
	/**
	 * 商家店铺名重复
	 */
	public final static String SAME_BUSINESSNAME="商家店铺名重复";
	/**
	 * 密码重置成功
	 */
	public final static String SUCESS_REPLACE="密码重置成功,初始化为123456";
	/**
	 * 账户禁用成功
	 */
	public final static String SUCESS_DISABLED="账户禁用成功";
	/**
	 * 账户启用成功
	 */
	public final static String SUCESS_ENABLED="账户启用成功";
	/**
	 * 系统错误
	 */
	public final static String ERROR_SYSTEM="系统错误";
	
	/**
     * 提交成功
     */
    public final static String SUCESS_SUBMIT="提交成功";
    
    /**
     * 该地区已设置
     */
    public final static String HAVE_REGION="该地区已设置";
    
    /**
     * 该类别已有商品
     */
    public final static String HAVE_GOODS="该类别下已有商品";
    /**
     * 一级分类已存在
     */
    public final static String HAVE_SAME_LEVELONE="一级分类已存在";
    
    /**
     * 二级分类已存在
     */
    public final static String HAVE_SAME_LEVELTWO="二级分类已存在";

    public final static String SUCESS_TG="推广成功";
    /**
     * 该无效原因已存在
     */
    public final static String HAVE_SAME_INVA="该无效原因已存在";
    
    /**
     * 该无效原因已存在
     */
    public final static String HAVE_USE_INVA="该无效原因已使用，无法删除";
    
    /**
     * 客戶已取消订单，无需发货
     */
    public final static String HAVE_CANCEL_ORDER="客戶已取消订单，无需发货";
    
    /**
     * 发货成功
     */
    public final static String SUCCESS_SEND_ORDER="发货成功";
    
    /**
     * 代金劵已消费，不能再消费
     */
    public final static String USE_VOUCHER_ERROR="代金劵已消费，不能再消费";
    
    /**
     * 消费成功
     */
    public final static String USE_VOUCHER_SUCCESS="消费成功";
    
    /**
     * 酒店服务名称不能重复
     */
    public final static String ERROR_SERVICE_NAME_ISSAME="服务名称不能重复";
    //=============push====================
    /**
     * 没有新数据可以push
     */
    public final static String NO_NEW_DATA="NO_NEW_DATA";
    
    /**
     * 部门名称重复
     */
    public final static String DEPARTMENTNAME_SAME="部门名称重复";
    
    /**
     * 楼层名存在
     */
    public final static String FLOOR_SAME="楼层名存在";
    
    /**
     * 房间号存在
     */
    public final static String ROOM_SAME="房间号存在";
    
    /**
     * 分类已存在
     */
    public final static String CAGETORY_EXIST="分类已存在";
    
    /**
     * 该分类下已有代金劵
     */
    public final static String HAVE_VOUCHER="该分类下已有代金劵";
    
    /**
     * 该分类下已有商家
     */
    public final static String HAVE_BUSINESSES="该分类下已有商家";
    
    /**
     * 广告位已存在
     */
    public final static String HAVE_LOCATION="广告位已存在";
    
    /**
     * 广告已使用
     */
    public final static String USE_ADVERTISEMENT="广告已使用,不能删除";
    
    /**
     * 该位置广告已满
     */
    public final static String AD_LOCATION_FULL="该位置广告已满";
    
    /**
     * 名优特产最多展示6个
     */
    public final static String MYTCMASTNUMBER="名优特产最多展示6个";
    /**
     * 名优特产已存在
     */
    public final static String HAVE_MYTC="名优特产已存在";
    
    /**
     * 该用户角色不允许登陆。
     */
    public final static String USER_NO_LOGIN="该用户角色不允许登陆";
    
    /**
     * 服务订单已完成。
     */
    public final static String SERVICE_COMPLATE="服务订单已完成";
    
    /**
     * 服务已取消。
     */
    public final static String SERVICE_CANCEL="服务订单已取消";
    
    /**
     * 娱乐订单已完成。
     */
    public final static String RECREATION_COMPLATE="娱乐订单已完成";
    
    /**
     * 娱乐订单已取消。
     */
    public final static String RECREATION_CANCEL="娱乐订单已取消";
    
    /**
     * 餐厅订单已完成。
     */
    public final static String RESTAURANT_COMPLATE="餐厅订单已完成";
    
    /**
     * 餐厅订单已取消。
     */
    public final static String RESTAURANT_CANCEL="餐厅订单已取消";
    

}
