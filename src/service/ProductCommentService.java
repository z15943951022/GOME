package service;

import entity.ProductComment;

public interface ProductCommentService {
	/**
	 * 根据商品id添加评论
	 * 
	 */
	int addByProductId(ProductComment productComment);
	/**
	 * 根据商品id查询评论
	 * 
	 */
	ProductComment selectByProductId(int ProductId);
}
