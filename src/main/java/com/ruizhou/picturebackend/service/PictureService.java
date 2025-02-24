package com.ruizhou.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruizhou.picturebackend.model.dto.PictureUploadRequest;
import com.ruizhou.picturebackend.model.dto.picture.PictureQueryRequest;
import com.ruizhou.picturebackend.model.dto.picture.PictureReviewRequest;
import com.ruizhou.picturebackend.model.dto.picture.PictureUploadByBatchRequest;
import com.ruizhou.picturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruizhou.picturebackend.model.entity.User;
import com.ruizhou.picturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RZ
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2025-02-17 16:16:16
 */
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );
    void clearPictureFile(Picture oldPicture);
}
