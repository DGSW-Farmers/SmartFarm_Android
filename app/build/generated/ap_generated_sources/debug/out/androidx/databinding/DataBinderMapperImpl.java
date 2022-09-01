package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new kr.hs.dgsw.campus.smartfarm.DataBinderMapperImpl());
  }
}
