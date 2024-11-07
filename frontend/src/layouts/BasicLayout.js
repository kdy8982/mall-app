import React from 'react'
import CategoryComponent from '../components/category/CategoryComponent'
import HeaderLayout from './HeaderLayout'

function BasicLayout({ children }) {
  return (
    <div className="min-w-[1024px]">
      <div className="flex justify-center">
        <header className="flex w-[1024px] items-center bg-gray-200 text-center">
          <HeaderLayout />
        </header>
      </div>

      <div className="flex items-center justify-center">
        <div className="flex w-[1024px]">
          <CategoryComponent />
          <div className="w-full text-center">{children}</div>
        </div>
      </div>
    </div>
  )
}

export default BasicLayout
