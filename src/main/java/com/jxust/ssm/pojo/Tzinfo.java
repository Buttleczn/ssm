package com.jxust.ssm.pojo;
/**
 * 用户实体类
 * 对应数据表tb_user
 * @author Peng
 * @Date2016年12月10日下午10:30:16
 */
public class Tzinfo {
	private Integer turn;
	
	private String id;

    private String capital;

    private String invest;
    
	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getInvest() {
		return invest;
	}

	public void setInvest(String invest) {
		this.invest = invest;
	}

    
}