import React from 'react'

function CategoryComponent(props) {
  return (
    <div className="w-[250px] bg-yellow-400">
      <div className="flex-col text-center">
        <div className="p-4">식품</div>
        <div className="p-4">생활용품</div>
        <div className="p-4">뷰티</div>
        <div className="p-4">홈인테리어</div>
        <div className="p-4">가전디지털</div>
        <div className="p-4">출산/유아동</div>
        <div className="p-4">완구/취미</div>
      </div>
    </div>
  )
}

export default CategoryComponent
