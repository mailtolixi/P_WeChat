package com.nnsuu.p;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.*;
import com.jfinal.weixin.sdk.jfinal.ApiController;

/**
 * Created by user on 16-8-12.
 */
public class P_WeChat_Api_Controller extends ApiController {

    ApiConfig apiConfig = new ApiConfig();
    @Override
    public ApiConfig getApiConfig() {

        // 配置微信 API 相关常量
        apiConfig.setToken(PropKit.get("token"));
        apiConfig.setAppId(PropKit.get("appId"));
        apiConfig.setAppSecret(PropKit.get("appSecret"));

        /**
         *  是否对消息进行加密，对应于微信平台的消息加解密方式：
         *  1：true进行加密且必须配置 encodingAesKey
         *  2：false采用明文模式，同时也支持混合模式
         */
        apiConfig.setEncryptMessage(PropKit.getBoolean("encryptMessage", false));
        apiConfig.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
        ApiConfigKit.setThreadLocalApiConfig(apiConfig);
        return apiConfig;
    }

    /**
     * 获取公众号菜单
     */
    public void getMenu() {
//        ApiResult apiResult = MenuApi.getCurrentSelfMenuInfo();
//        ApiResult apiResult = MenuApi.getMenu();
//        if (apiResult.isSucceed())
//            renderText(apiResult.getJson());
//        else
//            renderText(apiResult.getErrorMsg());
        renderText(apiConfig.getAppId()+"\n"+apiConfig.getAppSecret()+"\n"+apiConfig.getToken());
    }


    /**
     * 创建菜单
     */
    public void createMenu()
    {
        String str = "{\n" +
                "    \"button\": [\n" +
                "        {\n" +
                "            \"name\": \"进入理财\",\n" +
                "            \"url\": \"http://m.bajie8.com/bajie/enter\",\n" +
                "            \"type\": \"view\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"安全保障\",\n" +
                "            \"key\": \"112\",\n" +
                "\t    \"type\": \"click\"\n" +
                "        },\n" +
                "        {\n" +
                "\t    \"name\": \"使用帮助\",\n" +
                "\t    \"url\": \"http://m.bajie8.com/footer/cjwt\",\n" +
                "\t    \"type\": \"view\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        ApiResult apiResult = MenuApi.createMenu(str);
        if (apiResult.isSucceed())
            renderText(apiResult.getJson());
        else
            renderText(apiResult.getErrorMsg());
    }

    /**
     * 获取公众号关注用户
     */
    public void getFollowers()
    {
        ApiResult apiResult = UserApi.getFollows();
        renderText(apiResult.getJson());
    }

    /**
     * 获取用户信息
     */
    public void getUserInfo()
    {
        //ApiResult apiResult = UserApi.getUserInfo("ohbweuNYB_heu_buiBWZtwgi4xzU");
        renderText("sssssssss");
    }

    /**
     * 发送模板消息
     */
    public void sendMsg(String userName)
    {
        //ok2SawYb90UhG8fkbsjEZ8pr25vs
        String str = " {" +
                "\"touser\":\""+userName+"\"," +
                "\"template_id\":\"uDioQA04i_aV8a0hgKjNsYeGE557X711FTEY7cH1Kj0\",\n" +

                "\"topcolor\":\"#FF0000\",\n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"恭喜你购买成功！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"去哪儿网发的酒店红包（1个）\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\":{\n" +
                "                       \"value\":\"1元\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"欢迎再次购买！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "}";
        ApiResult apiResult = TemplateMsgApi.send(str);
        renderText(apiResult.getJson());
    }

    /**
     * 获取参数二维码
     */
    public void getQrcode()
    {
        String str = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
        ApiResult apiResult = QrcodeApi.create(str);
        renderText(apiResult.getJson());

//        String str = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"123\"}}}";
//        ApiResult apiResult = QrcodeApi.create(str);
//        renderText(apiResult.getJson());
    }

    /**
     * 长链接转成短链接
     */
    public void getShorturl()
    {
        String str = "{\"action\":\"long2short\"," +
                "\"long_url\":\"http://wap.koudaitong.com/v2/showcase/goods?alias=128wi9shh&spm=h56083&redirect_count=1\"}";
        ApiResult apiResult = ShorturlApi.getShorturl(str);
        renderText(apiResult.getJson());
    }

    /**
     * 获取客服聊天记录
     */
    public void getRecord()
    {
        String str = "{\n" +
                "    \"endtime\" : 987654321,\n" +
                "    \"pageindex\" : 1,\n" +
                "    \"pagesize\" : 10,\n" +
                "    \"starttime\" : 123456789\n" +
                " }";
        ApiResult apiResult = CustomServiceApi.getRecord(str);
        renderText(apiResult.getJson());
    }

    /**
     * 获取微信服务器IP地址
     */
    public void getCallbackIp()
    {
        ApiResult apiResult = CallbackIpApi.getCallbackIp();
        renderText(apiResult.getJson());
    }
}
