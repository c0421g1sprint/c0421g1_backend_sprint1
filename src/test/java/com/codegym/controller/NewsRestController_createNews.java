package com.codegym.controller;

import com.codegym.entity.about_news.NewsDto;
import com.codegym.entity.about_news.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsRestController_createNews {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // NewsTitle
    // Test newTitle = null
    @Test
    public void createNews_newsTitle_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsTitle(null);

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test newsTitle = ""
    @Test
    public void createNews_newsTitle_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsTitle("");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test: createNews_newsTitle_15 => bỏ qua vì không có pattern.

    // Test minlength newsTitle (<10 ký tự)
    @Test
    public void createNews_newsTitle_16() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsTitle("ABC");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test maxlength newsTitle (> 100 ký tự)
    @Test
    public void createNews_newsTitle_17() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsTitle("Based on your input, get a random alpha numeric string. The random string generator creates a " +
                "series of numbers and letters that have no pattern. These can be helpful for creating security codes.\n");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // ImageUrl
    // Test imageUrl = null
    @Test
    public void createNews_imageUrl_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setImageUrl(null);

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test imageUrl = ""
    @Test
    public void createNews_imageUrl_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setImageUrl("");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test: createNews_imageUrl_15 => bỏ qua vì không có pattern.
    // Test: createNews_imageUrl_16 => bỏ qua vì không có minlength
    // Test: createNews_imageUrl_17 => bỏ qua vì không có maxlength.



    // NewsContent
    // Test newsContent = null
    @Test
    public void createNews_newsContent_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsContent(null);

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test newsContent = ""
    @Test
    public void createNews_newsContent_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsContent("");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test: createNews_newsContent_15 => bỏ qua vì không có pattern.

    // Test minlength newsContent (< 100 ký tự)
    @Test
    public void createNews_newsContent_16() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test maxlength newsContent (> 1024 ký tự)
    @Test
    public void createNews_newsContent_17() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsContent("Ngày 26-27/10, ảnh hưởng của áp thấp nhiệt đới khả năng mạnh thành bão khiến các tỉnh, thành phố từ Đà Nẵng đến Bình Thuận, Tây Nguyên và Đông Nam Bộ bước vào đợt mưa mới. Lượng mưa phổ biến 100-300 mm, " +
                "có nơi trên 300 mm. Vùng ven biển Nam Trung Bộ có gió mạnh cấp 5-6, giật cấp 8.\n" +
                "\"Do từ ngày 26/10, mưa lớn quay trở lại nên một số khu vực đã và đang còn ngập ở Quảng Nam, Quảng Ngãi sẽ có nguy cơ ngập úng, lũ quét và sạt lở rất cao\", ông Lâm khuyến cáo.\n" +
                "Chuyên gia cũng cho biết mưa lớn cùng gió giật mạnh sẽ gây nguy cơ mất an toàn đối với các hồ chứa, khu công nghiệp khai thác khoáng sản lớn ở Tây Nguyên và các lồng bè, khu nuôi trồng thủy sản ở Phú Yên, Khánh Hòa.\n" +
                "Đáng lưu ý, các tỉnh, thành phố Tây Nguyên và Đông Nam Bộ mưa lớn kéo dài trong những ngày tới, trong khi triều cường xuống chậm nên người dân đề phòng nguy cơ ngập úng từ sau 16h hàng ngày.\n" +
                "Ngày 27-30/10, vùng mưa lớn dịch chuyển lên phía bắc do ảnh hưởng của không khí lạnh và nhiễu động gió đông trên cao. Trong đợt này, khu vực từ Thanh Hóa đến Thừa Thiên - Huế được dự báo lượng mưa 200-350 mm, có nơi trên 400 mm.");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    // NewsBrief
    // Test newsBrief = null
    @Test
    public void createNews_newsBrief_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsBrief(null);

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test newsBrief = ""
    @Test
    public void createNews_newsBrief_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsBrief("");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test: createNews_newsBrief_15 => bỏ qua vì không có pattern.

    // Test minlength newsBrief (< 10 ký tự)
    @Test
    public void createNews_newsBrief_16() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsBrief("ABC");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test maxlength newsBrief (> 256 ký tự)
    @Test
    public void createNews_newsBrief_17() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsBrief("Thông tin trên được ông Hoàng Phúc Lâm, Phó giám đốc Trung tâm Dự báo Khí tượng Thủy văn Quốc gia," +
                " cho biết trong cuộc họp của Ban Chỉ đạo Quốc gia về phòng chống thiên tai, sáng 25/10. Cuộc họp nhằm lên các " +
                "phương án ứng phó với áp thấp nhiệt đới và tình hình mưa lớn phức tạp ở miền Trung những ngày tới.");

        Type type = new Type();
        type.setTypeId(4);
        newsDto.setType(type);

        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    // Type
    // Test type = null
    @Test
    public void createNews_type_13() throws Exception {
        NewsDto newsDto = new NewsDto();

        newsDto.setType(null);

        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test: createNews_type_14 => bỏ qua vì là kiểu object.
    // Test: createNews_type_15 => bỏ qua vì không có pattern.
    // Test: createNews_type_16 => bỏ qua vì không có minlength.
    // Test: createNews_type_17 => bỏ qua vì không có maxlength.



    // thuộc tính postDate được tự động khởi tạo khi tạo news mới.




    // Test: all item hợp lệ
    @Test
    public void createNews_18() throws Exception {
        NewsDto newsDto = new NewsDto();

        Type type = new Type();
        type.setTypeId(1);
        newsDto.setType(type);
        newsDto.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png");
        newsDto.setNewsContent("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setNewsTitle("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến.");
        newsDto.setNewsBrief("Nearpod là ứng dụng hàng đầu trong các tiết học tương tác trực tuyến nhằm giúp học sinh tương tác với nội dung bài học qua nhiều nhiệm vụ và hoạt động khác nhau. ");
        newsDto.setPostDate(new java.sql.Date(System.currentTimeMillis()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/news/create")
                .content(this.objectMapper.writeValueAsString(newsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
