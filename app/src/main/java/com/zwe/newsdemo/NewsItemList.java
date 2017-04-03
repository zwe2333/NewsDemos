package com.zwe.newsdemo;

import java.util.List;

/**
 * Created by Asus on 2017/4/2.
 */

public class NewsItemList {

    /**
     * size : 10
     * list : [{"imgurl":"http://cms-bucket.nosdn.127.net/711227de5b7f4c2b867a55ab11024de320170331172720.png","has_content":true,"docurl":"http://travel.163.com/17/0331/17/CGSFFK3900067VF3.html","id":27573,"time":"2017-03-31 17:28:14","title":"这个国家没人承认 可它的宪法有点屌","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/ff24e1aa37134ed688f6b0586b98ecd720170331172233.png","has_content":true,"docurl":"http://travel.163.com/17/0331/17/CGSF5OMD00067VF3.html","id":27575,"time":"2017-03-31 17:22:51","title":"趁国人还没涌入 快去这个不输大溪地的免签海岛!","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/bec4540403b44e6e98f85abeb8f654d120170331171653.png","has_content":true,"docurl":"http://travel.163.com/17/0331/17/CGSESCU600067VF3.html","id":27578,"time":"2017-03-31 17:17:44","title":"高能预警!18个去了可能遗憾终身的国内坑爹景点","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/9d6af25b46184df78e94a617835b549a20170331171259.png","has_content":true,"docurl":"http://travel.163.com/17/0331/17/CGSEK5N500067VF3.html","id":27574,"time":"2017-03-31 17:13:14","title":"90岁老奶奶踏上人生的毕业旅行 感动了全世界","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/c43bf984855d4e5fb7fac0a95692103320170331164217.png","has_content":true,"docurl":"http://travel.163.com/17/0331/16/CGSCRM3T00067VF3.html","id":27579,"time":"2017-03-31 16:42:23","title":"全球＂最色＂街道 进去就不想再出来了!","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/577f5f3321fa49168af30d8acb819d8620170331153807.png","has_content":true,"docurl":"http://dy.163.com/v2/article/detail/CGS31KSQ0525AMD1.html","id":27577,"time":"2017-03-31 13:50:53","title":"大爷用15万个矿泉水瓶搭建小岛 成功吸引日本超模","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/c06f3adf377847008317070e6003216720170331123550.png","has_content":true,"docurl":"http://travel.163.com/17/0331/12/CGRUM21A00067VF3.html","id":27419,"time":"2017-03-31 12:34:39","title":"想在国外自驾?这里有关于＂国际驾照＂的一切！","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/177f1d82e1694b9db5a2b33ac2d5193720170331123028.png","has_content":true,"docurl":"http://travel.163.com/17/0331/12/CGRUF62J00067VF3.html","id":27418,"time":"2017-03-31 12:30:54","title":"梵高画中如梦场景 在真实世界中竟也美得不像话！","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/277166b8b67f4e2d9a44e975a50ae90620170331122428.png","has_content":true,"docurl":"http://travel.163.com/17/0331/12/CGRU494J00067VF3.html","id":27420,"time":"2017-03-31 12:24:56","title":"不了解故宫的前世与今生 你就没来过故宫","channelname":"travel"},{"imgurl":"http://cms-bucket.nosdn.127.net/bded5d49e0ff4a76a2642ee9b3087f0620170331122038.png","has_content":true,"docurl":"http://travel.163.com/17/0331/12/CGRTUEP800067VF3.html","id":27417,"time":"2017-03-31 12:21:46","title":"美＂色＂当前:有些路,你的车比你更想走!","channelname":"travel"}]
     */

    private int size;
    /**
     * imgurl : http://cms-bucket.nosdn.127.net/711227de5b7f4c2b867a55ab11024de320170331172720.png
     * has_content : true
     * docurl : http://travel.163.com/17/0331/17/CGSFFK3900067VF3.html
     * id : 27573
     * time : 2017-03-31 17:28:14
     * title : 这个国家没人承认 可它的宪法有点屌
     * channelname : travel
     */

    private List<ListBean> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String imgurl;
        private boolean has_content;
        private String docurl;
        private int id;
        private String time;
        private String title;
        private String channelname;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public boolean isHas_content() {
            return has_content;
        }

        public void setHas_content(boolean has_content) {
            this.has_content = has_content;
        }

        public String getDocurl() {
            return docurl;
        }

        public void setDocurl(String docurl) {
            this.docurl = docurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelname() {
            return channelname;
        }

        public void setChannelname(String channelname) {
            this.channelname = channelname;
        }
    }
}
