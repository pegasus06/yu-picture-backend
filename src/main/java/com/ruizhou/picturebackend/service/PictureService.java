package com.ruizhou.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruizhou.picturebackend.model.dto.PictureUploadRequest;
import com.ruizhou.picturebackend.model.dto.picture.PictureQueryRequest;
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
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);
    void validPicture(Picture picture);
}
