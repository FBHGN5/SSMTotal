package org.total.web;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.total.entity.ReturnContant;
import org.total.message.GetMessageCode;
import org.total.util.EmailUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/total")
public class CodeController {


    /**
     * 根据获取到的手机号发送验证码
     * @param request
     * @param phone 获取的手机号码
     * @return
     */
    ReturnContant returnContant=new ReturnContant();
    @RequestMapping(value="/sendSMS",method= RequestMethod.POST)
    public @ResponseBody ReturnContant sendSMS(HttpServletRequest request,String phone) throws JSONException {
        //根据获取到的手机号发送验证码
        String code=GetMessageCode.getCode(phone);
        returnContant.setStatus(1);
        returnContant.setData(code);
        return returnContant;
    }
    @RequestMapping(value = "sendqq",method = RequestMethod.POST)
    @ResponseBody
    public ReturnContant sendqq(@RequestParam("qq")String qq)
    {
       String code= EmailUtil.sendEmain(qq);
       System.out.println(qq+"邮箱");
       returnContant.setData(code);
       return returnContant;
    }
}