package com.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.MultipartFile;

import com.entity.GoodsInfo;
import com.entity.TGF;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GoodsService;
import com.service.TgfService;

public class GoodsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -123172674311046432L;

	private int goods_id;
	private String goods_name;
	private float price;
	private float ticheng;
	private float reward;
	private int reward_num;
	private float admin;
	private int admin_num;
	private String goods_image;
	private String describe_goods;
	private float market_price;
	private String imgFormat;
	
	private float tuiguangfei;
	private float tuiguangfei1;
	private float tuiguangfei2;
	private float tuiguangfei3;
	private float tuiguangfei4;
	private float tuiguangfei5;
	private float tuiguangfei6;
	
	private TgfService tgfService;
	private GoodsService goodsService;
	
	private List<Object> lists3 = new ArrayList<>();
	private List<GoodsInfo> lists = new ArrayList<GoodsInfo>();
	private List<TGF> lists2 = new ArrayList<TGF>();
	private InputStream inputStream; //这个名字和struts.xml中对应，不能写错  
	
	//对应表单的file1  <input type="file" name="file1"/>
	private File file1;
	//当前上传的文件名
	private String file1FileName;
	//文件类型(MIME)
	@SuppressWarnings("unused")
	private String file1ContentType;
	
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	   }		
	
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }  

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public TgfService getTgfService() {
		return tgfService;
	}
	public void setTgfService(TgfService tgfService) {
		this.tgfService = tgfService;
	}
	
	//这个方法必须写上
    public List<GoodsInfo> getLists() {
        return lists;
    }
    public void setLists(List<GoodsInfo> lists) {
        this.lists = lists;
    }
    
    public String getImgFormat() {
		return imgFormat;
	}
	public void setImgFormat(String imgFormat) {
		this.imgFormat = imgFormat;
	}
	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTicheng() {
		return ticheng;
	}

	public void setTicheng(float ticheng) {
		this.ticheng = ticheng;
	}

	public float getReward() {
		return reward;
	}

	public void setReward(float reward) {
		this.reward = reward;
	}

	public int getReward_num() {
		return reward_num;
	}

	public void setReward_num(int reward_num) {
		this.reward_num = reward_num;
	}

	public float getAdmin() {
		return admin;
	}

	public void setAdmin(float admin) {
		this.admin = admin;
	}

	public int getAdmin_num() {
		return admin_num;
	}

	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public String getDescribe_goods() {
		return describe_goods;
	}

	public void setDescribe_goods(String describe_goods) {
		this.describe_goods = describe_goods;
	}
	
	
	public float getMarket_price() {
		return market_price;
	}
	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}
	
	public float getTuiguangfei() {
		return tuiguangfei;
	}
	public void setTuiguangfei(float tuiguangfei) {
		this.tuiguangfei = tuiguangfei;
	}
	public float getTuiguangfei1() {
		return tuiguangfei1;
	}
	public void setTuiguangfei1(float tuiguangfei1) {
		this.tuiguangfei1 = tuiguangfei1;
	}
	public float getTuiguangfei2() {
		return tuiguangfei2;
	}
	public void setTuiguangfei2(float tuiguangfei2) {
		this.tuiguangfei2 = tuiguangfei2;
	}
	public float getTuiguangfei3() {
		return tuiguangfei3;
	}
	public void setTuiguangfei3(float tuiguangfei3) {
		this.tuiguangfei3 = tuiguangfei3;
	}
	public float getTuiguangfei4() {
		return tuiguangfei4;
	}
	public void setTuiguangfei4(float tuiguangfei4) {
		this.tuiguangfei4 = tuiguangfei4;
	}
	public float getTuiguangfei5() {
		return tuiguangfei5;
	}
	public void setTuiguangfei5(float tuiguangfei5) {
		this.tuiguangfei5 = tuiguangfei5;
	}
	public float getTuiguangfei6() {
		return tuiguangfei6;
	}
	public void setTuiguangfei6(float tuiguangfei6) {
		this.tuiguangfei6 = tuiguangfei6;
	}
	
	public List<Object> getLists3() {
		return lists3;
	}
	public void setLists3(List<Object> lists3) {
		this.lists3 = lists3;
	}
	public List<TGF> getLists2() {
		return lists2;
	}
	public void setLists2(List<TGF> lists2) {
		this.lists2 = lists2;
	}
	public String getState(){
        System.out.println("传统的ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public String searchGoods() throws UnsupportedEncodingException{//搜索商品，返回商品列表
		
		System.out.println("action.searchGoods方法执行");
		String result = goodsService.searchGoods();
		if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			lists = goodsService.findGoods();
			Gson gson = new Gson();
			System.out.println("lists:"+gson.toJson(lists));//查看json格式
			return "findSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			return "findFail";
		}
		return null;
		
	}
	
    public String updateGoods() throws IOException{
    	
    	System.out.println("action.updateGoods方法执行");
    	
    	//goods_id = goodsInfo.getGoods_id();
    	System.out.println("goods_id:"+goods_id);
    	String path="/goods_image";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    if(file1FileName != null){	    	
	    	GoodsInfo goodsInfo = new GoodsInfo();
	    	String prefix=file1FileName.substring(file1FileName.lastIndexOf(".")+1);//获取图片后缀
	    	String goodsid = String.valueOf(goods_id);	    	
	    	file1FileName = file1FileName.replaceFirst(file1FileName, goodsid+"."+prefix);//以goods_id+后缀命名图片名字
	    	imgFormat = file1FileName;
	    	goodsInfo.setImgFormat(imgFormat);
	    	File destFile=new File(target,file1FileName); 	
		    System.out.println("destFile:"+destFile);
		    //把上传的文件，拷贝到目标文件中
		    FileUtils.copyFile(file1, destFile);		
		    goods_image=destFile.getPath();
			System.out.println("goods_url:"+goods_image);
			goodsInfo.setGoods_image(goods_image);
	    }
	    if(file1FileName == null){
		    GoodsInfo goodsInfo = new GoodsInfo();
		    goods_image = goodsService.findItem(goods_id).get(0).getGoods_image();
		    imgFormat = goodsService.findItem(goods_id).get(0).getImgFormat();
			System.out.println("goods_url:"+goods_image);
			System.out.println("imgFormat:"+imgFormat);
			goodsInfo.setGoods_image(goods_image);
			goodsInfo.setImgFormat(imgFormat);
	    }
    	String result = goodsService.updateGoods(goods_id,goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price,imgFormat);
    	String result2 = tgfService.updateTgf(goods_id,tuiguangfei,tuiguangfei1,tuiguangfei2,tuiguangfei3,tuiguangfei4,tuiguangfei5,tuiguangfei6);
		if(result2.equals(com.service.impl.TgfServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("updateSuccess"  
                    .getBytes("UTF-8")); 
		}else if(result2.equals(com.service.impl.TgfServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("updateFail"  
                    .getBytes("UTF-8")); 
		}
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){
    		inputStream = new ByteArrayInputStream("updateSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品更新成功");
			return "updateSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("updateFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品更新失败");
			return "updateFail";
	}
    	
    	return null;	
   }
    
    public String deleteGoods() throws UnsupportedEncodingException{
    	
    	System.out.println("action.deleteGoods方法执行");
    	String result = goodsService.deleteGoods(goods_id);
		if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("deleteSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品删除成功");
			return "deleteSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("deleteFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品删除失败");
			return "deleteFail";
		}
		return null;		
    }
    
    public String addGoods() throws IOException{
    	
    	System.out.println("action.addGoods方法执行");   
    	String path="/goods_image";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    if(file1FileName == null){
//	    	File destFile=new File(target,"demo.png");
//	    	//FileUtils.copyFile(file1, destFile);
		    GoodsInfo goodsInfo = new GoodsInfo();
		    goods_image = null;
		    imgFormat = null;
			System.out.println("goods_url:"+goods_image);
			goodsInfo.setGoods_image(goods_image);
			goodsInfo.setImgFormat(imgFormat);
	    }
	    String result = goodsService.addGoods(goods_name,price,ticheng,reward,reward_num,admin,admin_num,goods_image,describe_goods,market_price,imgFormat); 
    	if(file1FileName != null){ 
	    	GoodsInfo goodsInfo = new GoodsInfo();
	    	goods_id = goodsService.findGoodsId();
	    	//System.out.println("goods_id: "+goods_id);
	    	String prefix=file1FileName.substring(file1FileName.lastIndexOf(".")+1);
	    	String goodsid = String.valueOf(goods_id);	    	
	    	file1FileName = file1FileName.replaceFirst(file1FileName, goodsid+"."+prefix);//以goods_id加后缀命名图片名字
	    	imgFormat = file1FileName;
	    	goodsInfo.setImgFormat(imgFormat);
	    	System.out.println("file name: "+file1FileName);
	    	File destFile=new File(target,file1FileName);	    	
		    System.out.println("destFile:"+destFile);
		    //把上传的文件，拷贝到目标文件中
		    FileUtils.copyFile(file1, destFile);		
		    goods_image=destFile.getPath();
			System.out.println("goods_url:"+goods_image);
			goodsInfo.setGoods_image(goods_image);
	    }
    	if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("addSuccess"  
                    .getBytes("UTF-8")); 
			System.out.println("商品添加成功");			
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("addFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品添加失败");
		}
    	String result1 = tgfService.saveTgf(goods_id,tuiguangfei,tuiguangfei1,tuiguangfei2,tuiguangfei3,tuiguangfei4,tuiguangfei5,tuiguangfei6);//存推广费
		if(result1.equals(com.service.impl.TgfServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("addSuccess"  
                    .getBytes("UTF-8")); 
		}else if(result1.equals(com.service.impl.TgfServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("addFail"  
                    .getBytes("UTF-8"));
		}
    	System.out.println("goods_id:"+goods_id);
    	System.out.println("goods_url:"+goods_image);
    	String result2 = goodsService.upload(goods_id,goods_image,imgFormat);//上传图片
		if(result2.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			inputStream = new ByteArrayInputStream("addSuccess"  
                    .getBytes("UTF-8")); 			
			System.out.println("商品图片上传成功");
			return "addSuccess";
		}else if(result2.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("addFail"  
                    .getBytes("UTF-8")); 
			System.out.println("商品图片上传失败");
			return "addFail";			
    }
		return null;
    }
    
    public String uploadGoodsImage() throws IOException{
    	
    	System.out.println("action.uploadGoodsImage方法执行");
    	String path="WebContent/goods_image";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    
	    if(file1FileName != null){
	    	File destFile=new File(target,file1FileName);
		    System.out.println("destFile:"+destFile);
		    //把上传的文件，拷贝到目标文件中
		    FileUtils.copyFile(file1, destFile);
		    GoodsInfo goodsInfo = new GoodsInfo();
		    goods_image=destFile.getPath();
			System.out.println("goods_url:"+goods_image);
			goodsInfo.setGoods_image(goods_image);
			String result=goodsService.upload(goods_id,goods_image,imgFormat);
			if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
				inputStream = new ByteArrayInputStream("uploadSuccess"  
	                    .getBytes("UTF-8")); 
				System.out.println("商品图片上传成功");
				return "uploadSuccess";
			}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
				inputStream = new ByteArrayInputStream("uploadaddFail"  
	                    .getBytes("UTF-8")); 
				System.out.println("商品图片上传失败");
				return "uploadFail";
			}	
	    }
		return null;
    }
    
    public String searchItem() throws UnsupportedEncodingException{
    	
    	System.out.println("action.searchItem方法执行");
    	System.out.println("goods_id:"+goods_id);
		String result = goodsService.searchItem(goods_id);
		if(result.equals(com.service.impl.GoodsServiceImpl.SUCCESS)){//search success
			lists = goodsService.findItem(goods_id);
			String result2 = tgfService.searchTgf(goods_id);
			if(result2.equals(com.service.impl.TgfServiceImpl.SUCCESS)){//search success
				lists2 = tgfService.findTgf(goods_id);
			}else if(result2.equals(com.service.impl.TgfServiceImpl.FAIL)){
				inputStream = new ByteArrayInputStream("saveFail"  
	                    .getBytes("UTF-8")); 
			}
			Gson gson = new Gson();
			System.out.println("lists2:"+gson.toJson(lists2));
			lists3.addAll(lists);
			lists3.addAll(lists2);
			return "findItemSuccess";
		}else if(result.equals(com.service.impl.GoodsServiceImpl.FAIL)){
			inputStream = new ByteArrayInputStream("fail"  
                    .getBytes("UTF-8")); 
			return "findItemFail";
		}
		return null;
    }
    
	
}
