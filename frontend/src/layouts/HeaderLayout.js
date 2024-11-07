import React from 'react'

function HeaderLayout(props) {
  return (
    <>
      <div className="h-full w-[250px] flex-col">
        <div className="h-[100px] bg-blue-400">logo</div>
        <div className="h-[40px] bg-red-300">
          <div>
            <span>전체 카테고리</span>
          </div>
        </div>
      </div>
      <div className="w-[700px]">search box</div>
      <div className="">
        icon menu(mypage, cart)
        <div>login</div>
      </div>
    </>
  )
}

export default HeaderLayout
