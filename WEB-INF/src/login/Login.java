package login;

/**
 * ログイン処理クラス.
 * 今回は親クラスとして使用.
 * LoginDB.java 継承用
 */
public class Login {
	/**
	 * 指定されたIDとパスワードに紐づくユーザ情報を返却します.
	 * @param id	ID
	 * @param pass	パスワード
	 * @return ユーザ情報
	 */
	public LoginUserBean getUserData(String id, String password) {
		LoginUserBean bean = new LoginUserBean();
		
		// 引数のIDとパスワードを判定
		if(id == null || id.equals("") || password == null || password.equals("")) {
			// IDが合致しない場合はnullを代入
			bean = null;
			
		} else {

			bean.setId(id);
		}
		return bean;
	}
}