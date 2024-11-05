import React from 'react'

function BasicLayout({ children }) {
  return (
    <div>
      <div className="flex justify-center">
        <header className="flex h-[115px] w-[1200px] items-center bg-gray-200 text-center">
          <span className="w-2/12">logo</span>
          <div className="w-7/12">search box</div>
          <div className="w-3/12">
            icon menu(mypage, cart)
            <div>login</div>
          </div>
        </header>
      </div>
      <div className="flex items-center justify-center">
        <div className="w-[1300px] bg-green-300 text-center">{children}</div>
      </div>
    </div>
  )
}

export default BasicLayout
