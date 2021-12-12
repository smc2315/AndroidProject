package com.example.androidproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentShop extends Fragment {
    RecyclerView myRecyclerView;
    RecyclerView.LayoutManager myLayoutManager;
    EditText searchET;
    ShopAdapter shopAdapter;
    ArrayList<Picture> pictureInfo,filteredList;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_shop, container, false);
        myRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler1);
        myRecyclerView.setHasFixedSize(true);
        //myLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        searchET = rootView.findViewById(R.id.searchPicture);
        pictureInfo = new ArrayList<>();
        filteredList = new ArrayList<>();


        pictureInfo.add(new Picture(R.drawable.pic1_1,R.drawable.pic1_2,"강변",1500000,"1,500,000원", new String[]{"2021", "캔버스에 oil", "53 X 40.9", "비오는 날 한강 산책로 벤치에 앉아 맑은 날의 풍경이 같은 시간에 있는 듯 과거,현재,미래를 통합한 시점으로 바라본다."}));
        pictureInfo.add(new Picture(R.drawable.pic2_1,R.drawable.pic2_2,"여수 밤바다",2300000,"2,300,000원",new String[]{"2021","캔버스에 oil","53 X 40.9","9월의 여수는 동백꽃이 안피어 있지만, 오동도에 활짝 핀 동백꽃은 마음에 피어 여수 밤바다의 화려한 조명과 어우러진다."}));
        pictureInfo.add(new Picture(R.drawable.pic3_1,R.drawable.pic3_2,"종말",1200000,"1,200,000원",new String[]{"2021","캔버스에 oil","53 X 40.9","넝쿨 식물로 뒤덮인 나무들. 인간의 욕망은 아름다움을 추구하는 듯 보이지만 그건은 불에 타버릴 종말이 기다릴 뿐..."}));
        pictureInfo.add(new Picture(R.drawable.pic4_1,R.drawable.pic4_2,"회개한자",3200000,"3,200,000원",new String[]{"2021","캠버스에 oil","53 X 40.9","예수님을 믿고 회개한 자는 빛속에 거한다."}));
        pictureInfo.add(new Picture(R.drawable.pic5_1,R.drawable.pic5_2,"바다",1800000,"1,800,000원",new String[]{"2021","캔버스에 oil","53 X 40.9","세상이라는 바다속에서 진리를 찾는다. 물고기 익투스는 예수 그리스도는 하나님의 아들이시요, 우리의 구원자이시다."}));
        pictureInfo.add(new Picture(R.drawable.pic6_1,R.drawable.pic6_2,"십자가",4500000,"4,500,000원",new String[]{"2021","캔버스에 oil","53 X 40.9","십자가에 구원이 있다."}));
        pictureInfo.add(new Picture(R.drawable.pic7_1,R.drawable.pic7_2,"그 자리",2400000,"2,400,000원",new String[]{"2021","캔버스에 oil","53 X 40.9","기도의 자리에서 성령님의 인도하심을 구한다."}));
        pictureInfo.add(new Picture(R.drawable.pic8_1,R.drawable.pic8_2,"아차산 연못",2800000,"2,800,000원",new String[]{"2021","캔버스에 oil","53 X 45.5","아차산 연못에 핀 연꽃과 새와 자라가 그들만의 방에서 하늘의 기운과 연결된 생명력을 가진다."}));
        pictureInfo.add(new Picture(R.drawable.picture,R.drawable.pic9_2,"고흐 별이 빛나는 밤에",1000000000,"1,000,000,000원",new String[]{"1889","캔버스에 oil","73.9 X 92.1","《별이 빛나는 밤》(The Starry Night)은 네덜란드의 화가 빈센트 반 고흐의 가장 널리 알려진 작품이다. 정신병을 앓고 있을 당시의 고흐가 그린 작품이다. 1889년 상 레미의 정신병원에서 나와 기억으로 그린 그림이자, 당시 고흐는 정신적 질환으로 인한 고통을 떠올려 그림 속의 소용돌이로 묘사했다.\n" +
                "\n" +
                "빈센트 반 고흐의 대표작 중 하나로 꼽히는 《별이 빛나는 밤》은 그가 고갱과 다툰 뒤 자신의 귀를 자른 사건 이후 생레미의 요양원에 있을 때 그린 것이다. 그는 병실 밖으로 내다보이는 밤 풍경을 기억과 상상을 결합시켜 그렸는데, 이는 자연에 대한 반 고흐의 내적이고 주관적인 표현을 구현하고 있다. 고흐에게 밤하늘은 무한함을 주는 대상이었고, 이보다 먼저 제작된 아를의 《밤의 카페 테라스》나 《론 강 위로 별이 빛나는 밤》에서도 별이 반짝이는 밤의 정경을 다루었다. 고흐는《별이 빛나는 밤》의 작업을 마쳤을 때 그다지 좋게 생각하지 않았다고 한다. 작품이 소개될 당시 미술계의 반응도 변변찮았다. 현재 이 그림은 1941년부터 뉴욕 현대미술관(MOMA)에서 상설 작품으로 전시되고 있다.\n" +
                "\n" +
                "연속적이고 동적인 터치로 그려진 하늘은 굽이치는 두꺼운 붓놀림으로 사이프러스와 연결되고, 그 아래의 마을은 대조적으로 고요하고 평온한 상태를 보여준다. 교회 첨탑은 그의 고향인 네덜란드를 연상시킨다. 그는 병실 밖으로 내다보이는 밤 풍경을 상상과 결합시켜 그렸는데, 이는 자연에 대한 반 고흐의 내적이고 주관적인 표현을 구현하고 있다. 수직으로 높이 뻗어 땅과 하늘을 연결하는 사이프러스는 전통적으로 무덤이나 애도와 연관된 나무지만, 반 고흐는 지옥을 불길하게 보지 않았다.\n" +
                "\n" +
                "몇몇 천문학자들은 이 작품의 별들이 실제 밤하늘의 별들이라고 설명한다 라고 한다. 당시 양자리의 별들과 금성, 그리고 달이 그림처럼 위치할 수 있다고 한다. 일반적으로 고흐가 정신병원의 침실의 창을 통해 본 밤하늘에서 영감을 얻었다고 하지만 일부에서는 이 그림에 나타난 11개의 별은 고흐가 성서 창세기 37장에 나오는 ‘열한 별’에서 영감을 얻은 것이라고 주장한다고 한다. 말하자면 이 그림의 요소는 집과 하늘이다."}));
        pictureInfo.add(new Picture(R.drawable.pic10_1,R.drawable.pic10_2,"고흐 자화상",1000000000,"1,000,000,000원",new String[]{"1887","캔버스에 oil","65 X 54","네덜란드 포스트 인상파 화가 빈센트 반 고흐는 1889 년 9 월 캔버스에 유화로 자화상을 그렸습니다.이 작품은 반 고흐의 마지막 자화상 이었을지 모르지만 그가 남부의 생 레미 드 프로방스를 떠나기 직전에 그렸습니다. 프랑스. 이 그림은 현재 파리의 오르세 미술관에 있습니다."}));




        shopAdapter = new ShopAdapter(pictureInfo);
        myRecyclerView.setAdapter(shopAdapter);
        shopAdapter.notifyDataSetChanged();

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String searchText = searchET.getText().toString();
                searchFilter(searchText);

            }
        });

        return rootView;

    }
    public void searchFilter(String searchText) {
        filteredList.clear();

        for (int i = 0; i <pictureInfo.size(); i++) {
            if (pictureInfo.get(i).getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(pictureInfo.get(i));
            }
        }

        shopAdapter.filterList(filteredList);
    }

}
