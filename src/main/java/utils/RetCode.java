package utils;

/**
 * @auth liweipeng
 * @version 2019年5月13日下午6:26:15
 **/
public enum RetCode {

	SUCCESS(200), // 成功

	FAIL(400), // 失败

	UNAUTHORIZED(401), // 未认证（签名错误）

	NOT_FOUND(404), // 接口不存在

	INTERNAL_SERVER_ERROR(500); // 服务器内部错误

	public int code;

	RetCode(int code) {
		this.code = code;
	}
}
